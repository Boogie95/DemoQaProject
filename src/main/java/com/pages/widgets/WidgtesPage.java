package com.pages.widgets;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;


public class WidgtesPage extends HomePage {

    By selectMenuLocator= By.xpath("//li[@id='item-8']/span[text()='Select Menu']");
    By selectDatePickerMenu= By.xpath("//li[@id='item-2']/span[text()='Date Picker']");
    By selectProgeessBarMenu= By.xpath("//li[@id='item-4']/span[text()='Progress Bar']");
    By selectSiderMenu= By.xpath("//li[@id='item-3']/span[text()='Slider']");

    public WidgtesPage(WebDriver driver) {
        super(driver);
    }


    public SelectMenuPage clickOnSelectMenu(){
        javaScriptUtility.scrollToElementJS(selectMenuLocator);
        click(selectMenuLocator);
        return new SelectMenuPage(driver);
    }
    public DatePickerMenu clickOnDatePickerMenu(){
        javaScriptUtility.scrollToElementJS(selectDatePickerMenu);
        click(selectDatePickerMenu);
        return new DatePickerMenu(driver);
    }
    public ProgressBarPage clickOnProgressBarMenu(){
        javaScriptUtility.scrollToElementJS(selectProgeessBarMenu);
        click(selectProgeessBarMenu);
        return new ProgressBarPage(driver);
    }
    public SliderPage clickOnSliderMenu(){
        javaScriptUtility.scrollToElementJS(selectSiderMenu);
        click(selectSiderMenu);
        return new SliderPage(driver);
    }
}
