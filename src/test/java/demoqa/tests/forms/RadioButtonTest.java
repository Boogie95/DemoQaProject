package demoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testRadioButton(){
        var formsPage=homePage.goToForms().clikcPracticeForm();
        formsPage.clickFemaleRadioButton();
        Assert.assertTrue(formsPage.isFemaleRadioButtonSelected(),"\n Female Radio Button is not selected \n");
    }
}
