package com.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class SliderPage extends WidgtesPage{

    By slider= By.xpath("//div[@id='sliderContainer']//input[@type='range']");
    By sliderValue=By.id("sliderValue");

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSliderTo(int desiredValue) {
        // Dohvati širinu slidera
        int sliderWidth = find(slider).getSize().getWidth();

        // Pomeraj se iz trenutne vrednosti na željenu
        int max = 100;
        int offset = (sliderWidth * desiredValue) / max;

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(find(slider), offset - sliderWidth / 2, 0).perform(); // reset pa offset
    }

    public String getSliderValue(){
        fluentWaitUntilVisible(10,sliderValue);
        return find(sliderValue).getAttribute("value");
    }


}
