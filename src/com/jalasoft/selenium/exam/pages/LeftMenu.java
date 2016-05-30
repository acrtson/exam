package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Alex Alvarez on 5/25/2016.
 */
public class LeftMenu extends AbstractBasePage{

    @FindBy(id = "filter_inbox")
    private WebElement inboxOption;

    @FindBy(id = "project_list_holder")
    private WebElement projectsMenu;

    public Inbox clickInboxOption(){
        wait.until(ExpectedConditions.elementToBeClickable(inboxOption));
        inboxOption.click();
        return new Inbox();
    }

    public AbstractBaseProjectPage clickProject(String project){
        projectsMenu.findElement(By.xpath("//span[contains(text(), '" + project + "')]")).click();
        return new AbstractBaseProjectPage();
    }
}
