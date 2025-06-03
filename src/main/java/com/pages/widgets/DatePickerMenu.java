package com.pages.widgets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DatePickerMenu extends WidgtesPage{

    By selectDateInput;
    By selectMonthDropDown= By.xpath("//select[@class='react-datepicker__month-select']");
    By selectYearDropDown= By.xpath("//select[@class='react-datepicker__year-select']");

    public DatePickerMenu(WebDriver driver) {
        super(driver);
        this.selectDateInput=By.id("datePickerMonthYearInput");
    }

    public DatePickerMenu(WebDriver driver,By calendar){
        super(driver);
        this.selectDateInput=calendar;
    }


    private By setDay(String day){
        return By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day--')][text()='"+day+"']");
    }


    public void selectDate(){
        waitForElementToBeClickable(selectDateInput);
        click(selectDateInput);
    }

    public void selectMonthDropDown(String month){
        selectDate();
        waitForElementToBeVisible(selectMonthDropDown);
        dropDownUtility.findDropDownDiv(selectMonthDropDown);
        dropDownUtility.selectByVisibleText(selectMonthDropDown,month);
    }
    public void selectYearDropDown(String year){
        selectDate();
        waitForElementToBeVisible(selectYearDropDown);
        dropDownUtility.findDropDown(selectYearDropDown);
        dropDownUtility.selectByVisibleText(selectYearDropDown,year);
    }

    public void setDayDropDown(String day){
        waitForElementToBeVisible(setDay(day));
        click(setDay(day));
    }
    //za verifikaciju mozemo da uzmemo sta je u input posle setovanja
    //i da vidimo da li je ta VALUE ista i u odredjenom formatu

    public String getValueFromInput(){
        return find(selectDateInput).getAttribute("value");
    }


}
