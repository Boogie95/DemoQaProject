package demoqa.tests.alertsframewind;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;
import utilities.AlertsUtitility;



public class AlertsTest extends BaseTest {

    @Test
    public void testInfoAlert()  {
        var alerts=homePage.goToAlertsFrameWindows().clickOnAlerts();
        AlertsUtitility alertsUtitility=new AlertsUtitility(driver);
        alerts.clickInfoAlertButton();
        String actual=alertsUtitility.getTextAlertBox();
        AlertsUtitility.alertOk();
        Assert.assertTrue(actual.contains("clicked"));

    }
    @Test
    public void testComfirmationAlert()  {
        var alerts=homePage.goToAlertsFrameWindows().clickOnAlerts();
        alerts.clickComfirmationButton();
        AlertsUtitility.alertCancel();
        String actual=alerts.getComfirationMessage();
        Assert.assertTrue(actual.contains("Cancel"));
    }
    @Test
    public void testPromptAlert(){
        var alerts=homePage.goToAlertsFrameWindows().clickOnAlerts();
        alerts.clickPromptButton();
        AlertsUtitility.insertPromptText("Jovan");
        AlertsUtitility.alertOk();
        String actual=alerts.getPromptResult();
        Assert.assertEquals(actual,"You entered Jovan");
    }

}
