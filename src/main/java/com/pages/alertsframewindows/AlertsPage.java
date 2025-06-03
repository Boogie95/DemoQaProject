package com.pages.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AlertsPage extends AlertsFrameWindowsPage{

    By alertButton= By.id("alertButton");
    By alertComfirmationButton=By.id("confirmButton");
    By comfirmationResult=By.id("confirmResult");
    By alertPromptButton= By.id("promtButton");
    By promptResult=By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    public void clickInfoAlertButton(){
        waitForElementToBeClickable(alertButton);
        click(alertButton);

    }

    public void clickComfirmationButton(){
        waitForElementToBeClickable(alertComfirmationButton);
        click(alertComfirmationButton);

    }

    public String getComfirationMessage(){
        return find(comfirmationResult).getText();
    }
    public String getPromptResult(){
        return find(promptResult).getText();
    }

    public void clickPromptButton(){
        waitForElementToBeClickable(alertPromptButton);
        click(alertPromptButton);
    }


}


