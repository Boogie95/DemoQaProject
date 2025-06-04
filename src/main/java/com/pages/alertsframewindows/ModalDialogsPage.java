package com.pages.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ModalDialogsPage extends AlertsFrameWindowsPage{

    By smallModalButton= By.id("showSmallModal");
    By smallModaText=By.xpath("//div[contains(text(),'small modal')]");
    By smallModalCloseButton=By.id("closeSmallModal");

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSmallModalButton(){
        waitForElementToBeClickable(smallModalButton);
        click(smallModalButton);
        waitForElementToBeVisible(smallModalButton);
    }

    public String getSmallModalText(){
        waitForElementToBeVisible(smallModalButton);
        return find(smallModaText).getText();
    }

    public void clickSmallModalClose(){waitForElementToBeClickable(smallModalCloseButton);click(smallModalCloseButton);}


}
