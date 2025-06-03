package com.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProgressBarPage extends WidgtesPage{
    By startButton= By.id("startStopButton");
  //  By progressBar=By.cssSelector("div[role='progressbar']");
    By progressBarFinished=By.xpath("//div[contains(text(),'100%')]");

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }


    public void startTheProgressBar(){
        fluentWaitUntilVisible(30,startButton);
        click(startButton);
    }
    public String getProgressValue(){
        fluentWaitUntilVisible(30,progressBarFinished);
        return find(progressBarFinished).getAttribute("aria-valuenow");
    }





    }




