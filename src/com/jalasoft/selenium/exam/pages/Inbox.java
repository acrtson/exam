package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.selenium.exam.utils.CommonFunctions.setCell;
/**
 * Created by Alex Alvarez on 5/25/2016.
 */
public class Inbox extends AbstractBasePage{

    @FindBy(linkText = "Add Task")
    private WebElement plusAddTaskLink;

    @FindBy(xpath = "//div[contains(@class,'richtext_editor sel_richtext_editor')]")
    private WebElement taskNameTextField;

    @FindBy(name = "due_date")
    private WebElement dueDateTextField;

    @FindBy(xpath = "//span[contains(.,'Add Task')]")
    private WebElement addTaskButton;

    @FindBy(className = "dp_cal")
    private WebElement calendarView;

    @FindBy(xpath = "//img[@class='cmp_priority4 form_action_icon menu_icon']")
    private WebElement priorityIcon;

    @FindBy(id = "editor")
    private WebElement editorDiv;


    public Inbox clickPlusAddTaskLink(){
        wait.until(ExpectedConditions.elementToBeClickable(plusAddTaskLink));
        plusAddTaskLink.click();
        return this;
    }

    public Inbox setTaskName(String taskName){
        setCell(taskNameTextField, taskName, wait);
        return this;
    }

    public Inbox setDueDateTextField(String dueDateText){
        dueDateTextField.click();
        calendarView.findElement(By.xpath("//td[@axis='" + dueDateText +"']")).click();
        return this;
    }

    public Inbox setPriority(String priority) {
        return this;
    }


    public Inbox clickAddTaskButton(){
        addTaskButton.click();
        return this;
    }

    public String getTaskName(String taskName) {
        WebElement tasksList = editorDiv.findElement(By.cssSelector("ul[class='items']"));
        WebElement taskNameText = tasksList.findElement(By.xpath("//span[@class='text sel_item_content' and contains(text(), '" + taskName + "')]"));
        return taskNameText.getText();
    }

    public void deleteTask(String taskName) {
        WebElement tasksList = editorDiv.findElement(By.cssSelector("ul[class='items']"));
        WebElement taskNameText = tasksList.findElement(By.xpath("//span[@class='text sel_item_content' and contains(text(), '" + taskName + "')]"));

    }

    public void goToTask(String taskName) {
        WebElement tasksList = editorDiv.findElement(By.cssSelector("ul[class='items']"));
        WebElement taskRowLi = tasksList.findElement(By.xpath("//li[contains(text(), '" + taskName + "')]"));
        WebElement menuIcon = taskRowLi.findElement(By.xpath("//div[@class='icon menu cmp_menu_on gear_menu']"));
        menuIcon.click();
    }
}
