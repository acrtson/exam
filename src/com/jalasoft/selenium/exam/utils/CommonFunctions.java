package com.jalasoft.selenium.exam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alex Alvarez on 5/18/2016.
 */
public class CommonFunctions {

    public static void setCell(WebElement textField, String textFieldText, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(textFieldText);
    }

    public static void setTextField(WebElement textField, String textFieldText, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(textFieldText);
    }

    public static void setComboboxField(WebElement comboboxField, String selectVisibleText, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(comboboxField));
        Select select = new Select(comboboxField);
        select.selectByVisibleText(selectVisibleText);
    }

    public static void setCheckboxField(WebElement checkboxField, String status, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(checkboxField));
        if(status.toLowerCase().equals("yes")){
            if(!checkboxField.isSelected()){
                checkboxField.click();
            }
        } else{
            if(checkboxField.isSelected()) {
                checkboxField.click();
            }
        }
    }

    public static String getCurrentDate(String dateFormat){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(currentDate);
    }

    public static String getStampTime(){
        Date currentDate = new Date();
        return "" + currentDate.getTime();
    }
}
