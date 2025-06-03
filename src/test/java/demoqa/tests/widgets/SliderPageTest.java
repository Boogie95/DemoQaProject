package demoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class SliderPageTest extends BaseTest {
    @Test
    public void sliderBarTest(){
        var slider=homePage.goToWidgets().clickOnSliderMenu();
        slider.moveSliderTo(85);  // x za levo desno y za gore dole u osi
        String actual=slider.getSliderValue();
        System.out.println(actual);
        Assert.assertEquals(actual,"86");
        //nije isto za chrome i za firefox
        //nije isto ocitavanje px . vremenski razulicija
        //mora se vodi racuna
        //najbolje preko JSE
    }
}
