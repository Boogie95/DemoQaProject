package utilities;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import utilities.JavaScriptUtility.*;


public class DropDownUtility extends Utility{

    public DropDownUtility(WebDriver driver) {
        super(driver);
    }

    public Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    public  void selectByValue(By locator,String value){
        findDropDown(locator).selectByValue(value);
    }

    public  void selectByIndex(By locator,int i){
        findDropDown(locator).selectByIndex(i);
    }

    public  void selectByVisibleText(By locator,String value){
        findDropDown(locator).selectByVisibleText(value);
    }

    public  void deselectByValue(By locator,String value){
        findDropDown(locator).deselectByValue(value);
    }

    public  void deselectByValue(By locator,int i){
        findDropDown(locator).selectByIndex(i);
    }

    public  List<String> getAllSelectedOptions(By locator){
        List<String> options=new ArrayList<>();
        List<WebElement> elementList=findDropDown(locator).getAllSelectedOptions();
        for(WebElement option:elementList){
            options.add(option.getText());
        }
        return options;
    }

    public void findDropDownDiv(By locator)
    {

        driver.findElement(locator);

    }

    public void selectFromDropdown(By dropdownInput, String visibleText) {
        JavaScriptUtility.scrollToElementJS(dropdownInput);
        waitForElementToBeClickable(dropdownInput);
        driver.findElement(dropdownInput).click();

        By option = By.xpath("//div[text()='" + visibleText + "']");

        JavaScriptUtility.clickJS(option);


    }
    public String getSelectedValue(By locator){
        return driver.findElement(locator).getText();
    }


}
