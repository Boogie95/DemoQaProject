package com.pages.alertsframewindows;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;


public class AlertsFrameWindowsPage extends HomePage {
    By modalDialogs= By.xpath("//li[@id='item-4']/span[text()='Modal Dialogs']");
    By alerts= By.xpath("//li[@id='item-1']/span[text()='Alerts']");
    By frames=By.xpath("//li[@id='item-2']/span[text()='Frames']");
    By windowsMenu=By.xpath("//li[@id='item-0']/span[contains(text(),'Windows')]");

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    public ModalDialogsPage clickOnModalDialog(){
        JavaScriptUtility.scrollToElementJS(modalDialogs);
        waitForElementToBeClickable(modalDialogs);
        click(modalDialogs);
        return new ModalDialogsPage(driver);
    }
    public AlertsPage clickOnAlerts(){
        JavaScriptUtility.scrollToElementJS(alerts);
        waitForElementToBeClickable(alerts);
        click(alerts);
        return new AlertsPage(driver);
    }

    public FramePage clickOnFrame(){
        JavaScriptUtility.scrollToElementJS(frames);
        waitForElementToBeClickable(frames);
        click(frames);
        return new FramePage(driver);
    }
    public WindowsPage clickOnWindowsMenu(){
        JavaScriptUtility.scrollToElementJS(windowsMenu);
        waitForElementToBeClickable(windowsMenu);
        click(windowsMenu);
        return new WindowsPage(driver);
    }


}
