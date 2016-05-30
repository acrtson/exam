package com.jalasoft.selenium.exam.pages;

import java.awt.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.selenium.exam.utils.CommonFunctions.setCell;

/**
 * Created by Alex Alvarez on 5/27/2016.
 */
public class Task extends AbstractBaseProjectPage {
    @FindBy(xpath = "//div[contains(@class,'richtext_editor sel_richtext_editor')]")
    private WebElement taskNameTextField;

    @FindBy(name = "due_date")
    private WebElement dueDateTextField;

    @FindBy(css = "div[class='select_project']")
    private WebElement selectProjectDiv;

    @FindBy(xpath = "//span[contains(.,'Add Task')]")
    private WebElement addTaskButton;

    @FindBy(className = "dp_cal")
    private WebElement calendarView;

    @FindBy(xpath = "//img[@class='cmp_priority4 form_action_icon menu_icon']")
    private WebElement priorityIcon;

    private WebElement taskRow;

    public Task setTaskName(String taskName){
        setCell(taskNameTextField, taskName, wait);
        return this;
    }

    public Task selectDueDateTextField(String dueDateText){
        dueDateTextField.click();
        calendarView.findElement(By.xpath("//td[@axis='" + dueDateText +"']")).click();
        return this;
    }

    public Task selectProject(String project) {
        return this;
    }

    public Task selectPriority(String priority) {
        return this;
    }

    public SelectProject clickInboxSelect(){
        wait.until(ExpectedConditions.elementToBeClickable(selectProjectDiv));
        selectProjectDiv.click();
        return new SelectProject();
    }

    public Container clickAddTaskButton(){
        addTaskButton.click();
        return new Container();
    }

    public MenuIcon clickMenu(){
        taskRow.findElement(By.cssSelector("div[class='icon menu cmp_menu_on gear_menu']")).click();
        return new MenuIcon();
    }

    public void setTaskRow(WebElement taskRow) {
        this.taskRow = taskRow;
    }
}
