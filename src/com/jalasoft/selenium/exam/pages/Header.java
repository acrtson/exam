package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Alex Alvarez on 5/16/2016.
 */
public class Header extends AbstractBasePage{
    @FindBy(id = "icon_add_task")
    private WebElement plusLinkQuickAddTask;


    public Task clickPlusLinkQuickAddTask(){
        wait.until(ExpectedConditions.elementToBeClickable(plusLinkQuickAddTask));
        plusLinkQuickAddTask.click();
        return new Task();
    }
}
