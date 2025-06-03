package demoqa.tests.alertsframewind;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class WindowsHandlesTest extends BaseTest {
    @Test
    public void NewWindowTest() throws InterruptedException {
        var wind=homePage.goToAlertsFrameWindows().clickOnWindowsMenu();
        wind.clickWindowButton();
        wind.switchToNewWindow();
        String actualURL=driver.getCurrentUrl();
        System.out.println(actualURL);
        String actual=wind.getNewWindowsText();
        Assert.assertEquals(actual,"This is a sample page");
    }
}
