package demoqa.tests.alertsframewind;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class ModalTest extends BaseTest {
    @Test
    public void popUpTest(){
        var modal=homePage.goToAlertsFrameWindows().clickOnModalDialog();
        modal.clickSmallModalButton();
        modal.clickSmallModalClose();
        String actual= modal.getSmallModalText();
        Assert.assertTrue(actual.contains("small modal"));

    }
}
