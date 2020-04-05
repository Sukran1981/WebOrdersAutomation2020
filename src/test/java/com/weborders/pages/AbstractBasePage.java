package com.weborders.pages;
//it meant to be extended

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractBasePage {

    protected WebDriver driver=Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,20);


    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    public String getPageLogoText(){

        return pageLogo.getText();
    }

    public AbstractBasePage(){//OBJECT CREATED WITH CONSTRUCTOR MAKE IT RUNNABLE EXECUTED RUNNING

        PageFactory.initElements(Driver.getDriver(),this);//just for @Find annotaion
    }
}
