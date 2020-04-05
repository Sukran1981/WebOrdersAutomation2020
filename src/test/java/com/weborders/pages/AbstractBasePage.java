package com.weborders.pages;
//it meant to be extended

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractBasePage {

    protected WebDriver driver=Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,20);


    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    @FindBy(tagName = "h2")
    protected WebElement pageSubtitle;

    public String getPageSubtitleText(){

        BrowserUtilities.waitForPageToLoad(10);
        return pageSubtitle.getText().trim();
    }

    public String getPageLogoText(){

        return pageLogo.getText();
    }

    public AbstractBasePage(){//OBJECT CREATED WITH CONSTRUCTOR MAKE IT RUNNABLE EXECUTED RUNNING

        PageFactory.initElements(Driver.getDriver(),this);//just for @Find annotaion
    }

    public void navigateTo(String component){

        String locator="//a[text()='" + component + "']";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

    }
}
