package demoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckbox() throws InterruptedException {
        var formsPage=homePage.goToForms().clikcPracticeForm();
        formsPage.clickSportsCheck();
        formsPage.clickMusicCheck();
        Assert.assertTrue(formsPage.isSportsSelected(),"ISN'T SELECTED");
    }
}
