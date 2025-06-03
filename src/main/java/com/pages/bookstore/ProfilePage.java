package com.pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BookStorePage{

    By logoutButton=By.id("submit");
    By linkLogin=By.xpath("//a[text()='login']");
    By linkRegister=By.xpath("//a[text()='register']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserValue(){
        waitForElementToBeVisible(By.id("userName-value"));
        return find(By.id("userName-value")).getText();
    }
    public LoginPage logoutFromProfile(){
        waitForElementToBeClickable(logoutButton);
        click(logoutButton);
        return new LoginPage(driver);
    }
    public LoginPage goToLoginPage(){
        waitForElementToBeClickable(linkLogin);
        click(linkLogin);
        return new LoginPage(driver);
    }
    public RegisterPage goToRegisterPage(){
        waitForElementToBeClickable(linkRegister);
        click(linkRegister);
        return new RegisterPage(driver);

    }
}
