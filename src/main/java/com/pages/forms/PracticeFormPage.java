package com.pages.forms;


import com.pages.widgets.DatePickerMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.JavaScriptUtility;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPages{

        private By femaleRadioButton= By.id("gender-radio-2");
        private By sportsCheck=By.id("hobbies-checkbox-1");
        private By readingCheck=By.id("hobbies-checkbox-2");
        private By musicCheck=By.id("hobbies-checkbox-3");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    public void setName(String name){
            set(By.id("firstName"),name);
        }

        public void setLastame(String lastname){
        set(By.id("lastName"),lastname);
        }

        public void setValidFormatEmail(String email)  {
            String regexEmail="^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            // [\w-.]+ part before @ can contain letters,-,.
            //@ => MUST HAVE
            //([\w-]+\.) isto do sledeceg plusa
            //[\w-]{2,4}$ mora da se zavrsi sa slovima duzine 2-4
            if(!email.matches(regexEmail)){
                Assert.fail("INVALID EMAIL FORM ");
            }
            set(By.id("userEmail"),email);
        }

        public void setMobileNumber(String number){
            if(!number.matches("\\d{10}")) {
                Assert.fail("INVALID FORMAT");
            }
            set(By.id("userNumber"),number);
        }


        public void clickFemaleRadioButton() {
            JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
            scrollToElementJS(femaleRadioButton);
            javaScriptUtility.clickJS(femaleRadioButton);

        }

        public boolean isFemaleRadioButtonSelected(){
            return find(femaleRadioButton).isSelected();
        }

        public void clickSportsCheck() throws InterruptedException {
            if(!find(sportsCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(sportsCheck);
                javaScriptUtility.clickJS(sportsCheck);
            }
        }
        public void clickMusicCheck(){
            if(!find(musicCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(musicCheck);
                javaScriptUtility.clickJS(musicCheck);
            }
        }
        public void clickReadingCheck(){
            if(!find(readingCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(readingCheck);
                javaScriptUtility.clickJS(readingCheck);
            }
        }
        public void unClickSportsCheck(){
            if(find(sportsCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(sportsCheck);
                javaScriptUtility.clickJS(sportsCheck);
            }
        }
        public void unClickMusicCheck(){
            if(find(musicCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(musicCheck);
                javaScriptUtility.clickJS(musicCheck);
            }
        }
        public void unClickReadingCheck(){
            if(find(readingCheck).isSelected()){
                JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
                scrollToElementJS(readingCheck);
                javaScriptUtility.clickJS(readingCheck);
            }
        }
        public boolean isSportsSelected(){
            return find(sportsCheck).isSelected();
        }

        public void setBdayDate(String day,String month,String year){
            DatePickerMenu datePicker=new DatePickerMenu(driver,By.id("dateOfBirthInput"));
            datePicker.selectMonthDropDown(month);
            datePicker.selectYearDropDown(year);
            datePicker.setDayDropDown(day);
        }

        public void setCurrentAdress(String address){
            waitForElementToBeVisible(By.id("currentAddress"));
            find(By.id("currentAddress")).sendKeys(address+ Keys.ENTER);
        }

        public void setState(String state){
            waitForElementToBeVisible(By.id("state"));
            dropDownUtility.selectFromDropdown(By.id("state"),state);
        }
        public void setCity(String city){
            waitForElementToBeVisible(By.id("city"));
            dropDownUtility.selectFromDropdown(By.id("city"),city);
        }
        public void submitForm(){
            click(By.id("submit"));
        }
        public String verifyFormIsSubmitted(){
            waitForElementToBeVisible(By.id("example-modal-sizes-title-lg"));
            return find(By.id("example-modal-sizes-title-lg")).getText();
        }







}
