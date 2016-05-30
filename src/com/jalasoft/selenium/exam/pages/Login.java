package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.selenium.exam.utils.CommonFunctions.setTextField;


/**
 * Created by Alex Alvarez on 5/13/2016.
 */
public class Login extends AbstractBasePage{

    public static final String urlBase = "https://en.todoist.com/seeYou";
    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(linkText = "Log in")
    private WebElement loginButton;

    @FindBy(linkText = "Log in")
    private WebElement loginButton2;

    public Login() {
        driver.get(urlBase);
    }

    public void setEmailTextField(String username){
        setTextField(emailTextField, username, wait);
    }

    public void setPasswordTextField(String password){
        setTextField(passwordTextField, password, wait);
    }

    public Login clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        switchToiFrame();
        return this;
    }

    private void switchToiFrame(){
        driver.switchTo().frame("GB_frame");
        driver.switchTo().frame("GB_frame");
    }

    public MainContainer clickLoginButton2(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton2));
        loginButton2.click();
        driver.switchTo().defaultContent();
        return new MainContainer();
    }

    public Login loginAs(String userName, String password){
        setEmailTextField(userName);
        setPasswordTextField(password);
        return this;
    }


}
