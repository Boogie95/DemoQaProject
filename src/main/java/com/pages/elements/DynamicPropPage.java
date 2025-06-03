package com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DynamicPropPage extends ElementsPage{

    By buttonEnableAfter5sec= By.id("enableAfter");
    By buttonColorChange= By.id("colorChange");
    By buttonVisibleAfter5sec= By.id("visibleAfter");

    public DynamicPropPage(WebDriver driver) {
        super(driver);
    }


    public String getVisibleAfterButtonText(){
       waitForElementToBeVisible(buttonVisibleAfter5sec);
       return find(buttonVisibleAfter5sec).getText();
    }


}
