package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alex Alvarez on 5/13/2016.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public AbstractBasePage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this); //Si o si para los @FinBy(...)
    }


}
