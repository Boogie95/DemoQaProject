package com.pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BookStorePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String verifyImOnRegisterPage(){
        return find(By.tagName("h1")).getText();
    }
    public LoginPage backToLoginPage(){
        click(By.id("gotologin"));
        return new LoginPage(driver);
    }

}
