package com.pages.elements;

import com.pages.forms.PracticeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class WebTablesPage extends ElementsPage{

    private By ageEdit=By.id("age");
    private By submitButton=By.id("submit");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    //kada radimo sa tabelama bolje da se element nadje preko neceg unique npr email u ovom slucaju
    //jer dodavanjem nove kolone nama se lokator menja nece biti npr edit-2 nego edit-3 sto nije dobro
    public void clickEdit(String email){
        By edit= By.xpath("//div[text()='"+email+"']//following::span[@title='Edit']");
        //ovo following je sta sledi posle email ide age|email|Salary tj sta je posle email u istom redu
        click(edit);
    }
    public void setAge(String age){ set(ageEdit,age);}
    public void clickSubmit(){waitForElementToBeClickable(submitButton);click(submitButton);}

    public String getTableAge(String email){
        By tableAge=By.xpath("//div[text()='"+email+"']//preceding::div[1]");
        //slicno kao gore sta je ispred polja email u istom redu , pokusavaj da izbegnes indexe jer vrlo verovatno
        /// ce se u nekom trenutku promeniti!!!
        return find(tableAge).getText();
    }
    public void deleteRow(String email){
        By delete=By.xpath("//div[text()='"+email+"']//following::span[2]");
        click(delete);
    }

    public void addNewRowIntoTable(String name,String lastname,String email,String age,String salary,String dep){
        waitForElementToBeVisible(By.id("addNewRecordButton"));
        click(By.id("addNewRecordButton"));
        waitForElementToBeVisible(By.className("modal-content"));
        PracticeFormPage practiceFormPage=new PracticeFormPage(driver);
        set(By.id("firstName"),name);
        set(By.id("lastName"),lastname);
        practiceFormPage.setValidFormatEmail(email);
        set(By.id("age"),age);
        set(By.id("salary"),salary);
        set(By.id("department"),dep);
        click(By.id("submit"));
        fluentWaitUntilVisible(2,By.id("addNewRecordButton"));
    }


    public List<WebElement> getRows(){
        List<WebElement> allRows = driver.findElements(By.className("rt-tr-group"));
        List<WebElement> visibleRows = new ArrayList<>();
        for (WebElement row : allRows){
            if (!row.getText().isBlank()){
                visibleRows.add(row);
            }
        }
        return visibleRows;
    }



}
