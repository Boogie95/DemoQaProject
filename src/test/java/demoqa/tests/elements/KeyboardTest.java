package demoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class KeyboardTest extends BaseTest {
    @Test
    public void appUsingKeyBoardTest() {
        var textBoxPage=homePage.goToElements().clickOnTextBoxPage();
        textBoxPage.setFullName("Jovan Bundalo");
        textBoxPage.setEmail("jovan.bundalo.95@gmail.com");
        textBoxPage.setCurrentAddress("selo Jasenica bb");
        textBoxPage.setCurrentAddress("Negotin 19300");
        textBoxPage.setCurrentAddress("Srbija");
        textBoxPage.clickButton();
        String actual=textBoxPage.getFullInformation();
        Assert.assertTrue(actual.contains("Bundalo"));

    }
}
