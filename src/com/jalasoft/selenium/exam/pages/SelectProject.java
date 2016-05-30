package com.jalasoft.selenium.exam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex Alvarez on 5/27/2016.
 */
public class SelectProject extends AbstractBasePage {

    @FindBy(id = "amicomplete_floater")
    private WebElement selectProjectDiv;

    public Task selectProject(String project){
        WebElement projectSelected;

        String xpathProject = "//span[@class='truncated p_name' and contains(text(), '" + project + "')]";

        projectSelected = selectProjectDiv.findElement(By.xpath(xpathProject));
        projectSelected.click();

        return new Task();
    }
}
