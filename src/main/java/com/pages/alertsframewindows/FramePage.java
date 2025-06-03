package com.pages.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramePage extends AlertsFrameWindowsPage{

    String iframe1= "frame1";
    String iframe2= "frame2";
    By headerFramePage=By.xpath("//h1[text()='Frames']");
    By iFrameSmallBox=By.xpath("//div[@id='frame2Wrapper']/iframe");

    public FramePage(WebDriver driver) {
        super(driver);
    }

    private void switchToBigBox(){driver.switchTo().frame(iframe1);}
    private void switchToSmallBox(){driver.switchTo().frame(1);}
    private void switchToSmallBoxElement(WebElement element){
        driver.switchTo().frame(element);
    }

    //stavimo private da se koristi ovde i da ne mozemo da pozovemo iz FramesTest()
    //ako pozivamo nesto iz gornjeg dela hijerarhije SIGURNO NIJE DOBRO

    //imamo i funkcije za izlazenje iz iframe i to moramo da uradimo
    //ako zelimo da radimo opet sa elementima iz originalog/predhodnog doma
    //defaultContent()-ako smo zavrsili sa ifrom skrot vraca nas u pocetni DOM
    //parentFrame() ako ima ugnjezdenih vraca za jedan unazad


    //ako nemamo id ili name moramo da svitcujemo po webElementu

    public String getTextFromBigFrame(){
        switchToBigBox(); //skoci u iframe da bi video taj id, u suprotnom ga ne vidi
        By text=By.xpath("//h1[@id='sampleHeading']");
        String actual=find(text).getText();
        driver.switchTo().defaultContent();
        return actual;
    }
    public String getTextFromSmallFrame(){
        switchToSmallBox(); //skoci u iframe da bi video taj id, u suprotnom ga ne vidi
        By text=By.xpath("//h1[@id='sampleHeading']");
        String actual=find(text).getText();
        driver.switchTo().parentFrame();
        return actual;
    }
    public String getTextFromSmallFrameWebElement(){
        switchToSmallBoxElement(find(iFrameSmallBox));
        By text=By.xpath("//h1[@id='sampleHeading']");
        String actual=find(text).getText();
        driver.switchTo().parentFrame();
        return actual;
    }
    public String getHeaderFramesText(){
        return find(headerFramePage).getText();
    }
}
