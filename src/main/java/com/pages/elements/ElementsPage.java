package com.pages.elements;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;


public class ElementsPage extends HomePage {

    private By elementsWebTable= By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private By elementsLinks=By.xpath("//li[@id='item-5']/span[text()='Links']");
    private By dynamicProp=By.xpath("//li[@id='item-8']//span[contains(text(),'Dynamic')]");
    private By textBox=By.xpath("//li[@id='item-0']//span[contains(text(),'Box')]");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clikcPracticeWebTables(){
        waitForElementToBeVisible(elementsWebTable);
        javaScriptUtility.scrollToElementJS(elementsWebTable);
        javaScriptUtility.clickJS(elementsWebTable);
        return new WebTablesPage(driver);
    }

    public LinksPage clickOnLinks(){
        waitForElementToBeVisible(elementsLinks);
        javaScriptUtility.scrollToElementJS(elementsLinks);
        click(elementsLinks);
        return new LinksPage(driver);
    }
    public DynamicPropPage clickOnDynamicPage(){
        waitForElementToBeVisible(dynamicProp);
        javaScriptUtility.scrollToElementJS(dynamicProp);
        click(dynamicProp);
        return new DynamicPropPage(driver);
    }
    public TextBoxPage clickOnTextBoxPage(){
        waitForElementToBeVisible(textBox);
        javaScriptUtility.scrollToElementJS(textBox);
        click(textBox);
        return new TextBoxPage(driver);
    }


}
