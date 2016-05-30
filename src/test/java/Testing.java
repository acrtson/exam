package test.java;

import com.jalasoft.selenium.exam.pages.AbstractBaseProjectPage;
import com.jalasoft.selenium.exam.pages.Inbox;
import com.jalasoft.selenium.exam.pages.Login;
import com.jalasoft.selenium.exam.pages.MainContainer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jalasoft.selenium.exam.utils.CommonFunctions.getCurrentDate;
import static com.jalasoft.selenium.exam.utils.CommonFunctions.getStampTime;
import static org.testng.Assert.assertEquals;
/**
 * Created by Alex Alvarez on 5/25/2016.
 */
public class Testing {
    private Login login;

    private MainContainer mainContainer;

    private Inbox inboxPage;

    private String expectedTaskName = "task Name " + getStampTime();

    private String expectedProject = "Work";

    @BeforeClass
    public void setUp(){
        String email = "acrtson@gmail.com";
        String password = "Selenium123*";

        login = new Login();
        mainContainer = login.clickLoginButton()
                .loginAs(email, password)
                .clickLoginButton2();

    }

    @Test
    public void addTaskUsingInboxPage(){
        String priority = "priority1";
        String dateFormat = "yyyy|M|dd";

        inboxPage = mainContainer.goToLeftMenu().clickInboxOption()
                .clickPlusAddTaskLink()
                .setTaskName(expectedTaskName)
                .setDueDateTextField(getCurrentDate(dateFormat))
                .setPriority(priority)  //not working
                .clickAddTaskButton();

        assertEquals(inboxPage.getTaskName(expectedTaskName), expectedTaskName);
    }

    @Test
    public void addQuickTaskAtTheHeader(){

        mainContainer.goToHeader().clickPlusLinkQuickAddTask()
                .setTaskName(expectedTaskName).clickInboxSelect()
                .selectProject(expectedProject).clickAddTaskButton();

        AbstractBaseProjectPage abstractBaseProjectPage = mainContainer.goToLeftMenu().clickProject(expectedProject);

        assertEquals(abstractBaseProjectPage.getTaskName(expectedTaskName), expectedTaskName);


    }

    @AfterMethod
    public void deleteCreatedTask(){

        mainContainer.goToLeftMenu()
                .clickProject(expectedProject)
                .goToTask(expectedTaskName)
                .clickMenu();//.selectDeleteTaskOption();

    }


}
