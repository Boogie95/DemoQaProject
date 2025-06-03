package com.pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BookStorePage{

    By userName= By.id("userName");
    By password=By.id("password");
    By loginButton=By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username,String pass){
        set(userName,username);
        set(password,pass);
        waitForElementToBeClickable(loginButton);
        click(loginButton);
    }

    public String verifyImOnLoginPage(){
        waitForElementToBeVisible(By.tagName("h5"));
        return find(By.tagName("h5")).getText();
    }

    public boolean isLoginErrorDisplayed() {
        waitForElementToBeVisible(By.id("name"));
        return isElementDisplayed(By.id("name")) && !getText(By.id("name")).isBlank();
    }
    public boolean isStillOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }

    public boolean isUsernameFieldInvalid() {
        return find(By.id("userName")).getAttribute("class").contains("is-invalid");
    }

    public boolean isPasswordFieldInvalid() {
        return find(By.id("password")).getAttribute("class").contains("is-invalid");
    }
}
