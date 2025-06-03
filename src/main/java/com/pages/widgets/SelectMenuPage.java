package com.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;




public class SelectMenuPage extends WidgtesPage{

    By standardMultiSetDropDown= By.id("cars");
    By selectOneDropDown=By.xpath("//div[text()='Select Title']");
    By option = By.xpath("//div[contains(@class,'css-yt9ioa-option') and text()='']");

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public void selectStandardMulti(String text){
        javaScriptUtility.scrollToElementJS(standardMultiSetDropDown);
        dropDownUtility.findDropDown(standardMultiSetDropDown);
        dropDownUtility.selectByVisibleText(standardMultiSetDropDown,text);
        dropDownUtility.getAllSelectedOptions(standardMultiSetDropDown);
    }
    public void deselectStandardMulti(String text){
        javaScriptUtility.scrollToElementJS(standardMultiSetDropDown);
        dropDownUtility.findDropDown(standardMultiSetDropDown);
        dropDownUtility.deselectByValue(standardMultiSetDropDown,text);
        dropDownUtility.getAllSelectedOptions(standardMultiSetDropDown);
    }
    public void selectStandardMulti(int i){
        javaScriptUtility.scrollToElementJS(standardMultiSetDropDown);
        dropDownUtility.findDropDown(standardMultiSetDropDown);
        dropDownUtility.selectByIndex(standardMultiSetDropDown,i);
        dropDownUtility.getAllSelectedOptions(standardMultiSetDropDown);
    }
    public List<String> selectedOptionsList(){
        return dropDownUtility.getAllSelectedOptions(standardMultiSetDropDown);
    }

    public void selectOneFromDropMenu(String text){
        waitForElementToBeClickable(selectOneDropDown);
        click(selectOneDropDown);
        option = By.xpath("//div[contains(@class,'css-yt9ioa-option') and text()='" + text + "']");
        waitForElementToBeClickable(option);
        click(option);
    }


    public void selectTitle(String s) {
        dropDownUtility.selectFromDropdown(selectOneDropDown,s);
    }
}
