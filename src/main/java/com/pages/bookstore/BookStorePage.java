package com.pages.bookstore;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;

public class BookStorePage extends HomePage {
    By loginbutton= By.id("login");
    By profile=By.xpath("//li[@id='item-3']//span[contains(text(),'Profile')]");

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loggin(){
        waitForElementToBeClickable(loginbutton);
        click(loginbutton);
        return new LoginPage(driver);
    }
    public ProfilePage goToProfilePage(){
        waitForElementToBeVisible(profile);
        JavaScriptUtility.scrollToElementJS(profile);
        click(profile);
        return new ProfilePage(driver);
    }
}
