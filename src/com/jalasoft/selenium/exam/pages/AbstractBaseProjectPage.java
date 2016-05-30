package com.jalasoft.selenium.exam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex Alvarez on 5/27/2016.
 */
public class AbstractBaseProjectPage extends AbstractBasePage{

    @FindBy(id = "editor")
    private WebElement editorDiv;

    @FindBy(css = "ul[class='items']")
    private WebElement tasksList;

    public String getTaskName(String taskName) {
        WebElement tasksList = editorDiv.findElement(By.cssSelector("ul[class='items']"));
        WebElement taskNameText = tasksList.findElement(By.xpath("//span[@class='text sel_item_content' and contains(text(), '" + taskName + "')]"));
        return taskNameText.getText();
    }

    public Task goToTask(String expectedTaskName) {
        /*tasksList = editorDiv.findElement(By.cssSelector("ul[class='items']"));
        System.out.println("tasksList = " + tasksList.getTagName() + "]");
        WebElement taskRow = tasksList.findElement(By.xpath("//li[contains(text(), '" + expectedTaskName + "')]"));
        Task task = new Task();
        task.setTaskRow(taskRow);*/

        getTasksList();

        return new Task();
    }

    public void getTasksList(){
        List<WebElement> allTasks = editorDiv.findElements(By.xpath("//li")) ;
        for(WebElement element: allTasks){
            System.out.println(element.getText());
        }
    }
}
