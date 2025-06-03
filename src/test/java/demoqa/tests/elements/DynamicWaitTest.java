package demoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;
@Test
public class DynamicWaitTest extends BaseTest {


    public void visibleAfterButtonTest(){
        var dynamicPage=homePage.goToElements().clickOnDynamicPage();
        String actual=dynamicPage.getVisibleAfterButtonText();
        Assert.assertEquals(actual,"Visible After 5 Seconds");
    }

    public void progressBar100perTest(){
        var progressBarPage=homePage.goToWidgets().clickOnProgressBarMenu();
        progressBarPage.startTheProgressBar();
        String actual=progressBarPage.getProgressValue();
        Assert.assertEquals(actual,"100");

    }

}
