package com.pages.forms;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;


public class FormsPages extends HomePage {


        private By practceForm= By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

        public FormsPages(WebDriver driver) {
                super(driver);
        }


        public PracticeFormPage clikcPracticeForm(){
                waitForElementToBeVisible(practceForm);
                JavaScriptUtility.scrollToElementJS(practceForm);
                click(practceForm);
                return new PracticeFormPage(driver);
        }



}
