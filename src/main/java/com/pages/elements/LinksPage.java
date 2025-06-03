package com.pages.elements;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;



public class LinksPage extends ElementsPage {

    private By badRequest= By.id("bad-request");
    private By errorLinkResponse=By.id("linkResponse");
    private By homePageNewTab=By.id("simpleLink");

    public LinksPage(WebDriver driver) {
        super(driver);
    }


    public void clickBadRequestLink(){
        waitForElementToBeClickable(badRequest);
        javaScriptUtility.clickJS(badRequest);
    }
    public String getResponse(){
        waitForElementToBeVisible(errorLinkResponse);
        return find(errorLinkResponse).getText();
    }
    public HomePage clickHomePageNewTab()  {
        waitForElementToBeClickable(homePageNewTab);
        javaScriptUtility.openNewTab();
        return new HomePage(driver);
    }
}
