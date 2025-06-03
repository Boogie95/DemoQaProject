package com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;



public class TextBoxPage extends ElementsPage{
    By fullNameInput= By.xpath("//div[@id='userName-wrapper']//input");
    By emailInput = By.id("userEmail");
    By currentAdress=By.xpath("//textarea[@id='currentAddress']");
    By submitButton=By.id("submit");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void setFullName(String name){
        waitForElementToBeVisible(fullNameInput);
        find(fullNameInput).sendKeys(name,Keys.TAB);

    }

    public void setEmail(String email) {
        waitForElementToBeVisible(emailInput);
        find(emailInput).clear();
        find(emailInput).sendKeys(email, Keys.TAB); // TAB to move to address
    }

    public void setCurrentAddress(String address){
        waitForElementToBeVisible(currentAdress);
        find(currentAdress).sendKeys(address+Keys.ENTER);
    }
    public void clickButton(){
        waitForElementToBeClickable(submitButton);
        JavaScriptUtility.scrollToElementJS(submitButton);
        click(submitButton);
    }

    public String getFullInformation(){
        return find(By.xpath("//div[contains(@class,'border')]")).getText();
    }


}
