package com.pages.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;



public class WindowsPage extends AlertsFrameWindowsPage{

    By windowButton= By.id("windowButton");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWindowButton() {
        waitForElementToBeClickable(windowButton);
        click(windowButton);
    }

    public String getNewWindowsText(){

        return driver.findElement(By.id("sampleHeading")).getText();
    }

    public void switchToNewWindow() {
        String currentHand=driver.getWindowHandle(); //trenutni prozor
        Set<String> windowHandles = driver.getWindowHandles();//svi moguci prozori

        for(String handle:windowHandles){
            if(!currentHand.equals(handle)){
                driver.switchTo().window(handle);
            }
        }
    }

}
