package com.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

import java.time.Duration;

/* trebala bi da bude abstract jer je superklasa/parrent za sve ostale klase koje je nasledjuju
* subklase/child. Ovo radimo za PID(Page identification Design)/POM(Page Object Model).
* child klase bi bile npr LoginPage,HomePage...
* super klasa bi trebalo da ima sve sto je neophodno da imaju child klase.
* Koristi si vise kao skica(template) ima samo metode bez koda! a u child override i pisemo kod
* NE MOZE DA SE INSTANCIRA BAS ZBOG TOGA STO IMA ABSTRACT METODE TJ BEZ KODA!
* */
public class BasePage {

    protected WebDriver driver;
    protected Utility utility;
    protected ActionsUtility actionsUtility;
    protected AlertsUtitility alertsUtitility;
    protected DropDownUtility dropDownUtility;
    protected JavaScriptUtility javaScriptUtility;

    public BasePage(WebDriver driver){this.driver=driver;
        this.utility= new Utility(driver);
        this.actionsUtility= new ActionsUtility(driver);
        this.alertsUtitility=new AlertsUtitility(driver);
        this.dropDownUtility=new DropDownUtility(driver);
        this.javaScriptUtility=new JavaScriptUtility(driver);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void set(By locator,String text){
        find(locator).clear(); // ako ima vec nesto upisano OCISTI;
        find(locator).sendKeys(text);
    }

    public void click(By locator){ // za svaku stranu koja je child gde god da ima nesto da se klikne pozivamo ovu metodu
        find(locator).click();
    }


    public boolean isElementDisplayed(By locator){
        WebElement a=find(locator);
        return a.isDisplayed();
    }
    public String getText(By locator) {
        return find(locator).getText();
    }

    public  void waitForElementToBeClickable(By by){//Explicit wait
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public  void waitForElementToBeVisible(By by){ //Explicit wait
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public  void fluentWaitUntilVisible(int sec,By locator){
        FluentWait fluentWait=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(sec))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public  void waitForElementGetAtributeValue(By locator,int sec,String attribute,String value){
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(sec));
        webDriverWait.until(ExpectedConditions.attributeToBe(locator,attribute,value));
    }
}
