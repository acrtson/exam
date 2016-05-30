package com.jalasoft.selenium.exam.pages;

/**
 * Created by Alex Alvarez on 5/13/2016.
 */
public class MainContainer extends AbstractBasePage{

    public LeftMenu goToLeftMenu() {
        return new LeftMenu();
    }

    public Header goToHeader(){
        return new Header();
    }



    /*public Footer goToFooter(){
        return new Footer();
    }*/

}
