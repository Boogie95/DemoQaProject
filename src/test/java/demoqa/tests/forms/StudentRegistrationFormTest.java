package demoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class StudentRegistrationFormTest extends BaseTest {
    @Test
    public void submitFormTest() throws InterruptedException {
        var studentForm=homePage.goToForms().clikcPracticeForm();
        studentForm.setName("Jovan");
        studentForm.setLastame("Bundalo");
        studentForm.setValidFormatEmail("jovan.bundalo.95@gmail.com");
        studentForm.clickFemaleRadioButton();
        studentForm.setMobileNumber("0616287252");
        studentForm.clickMusicCheck();
        studentForm.setBdayDate("21","July","1995");
        studentForm.setState("Haryana");
        studentForm.setCity("Karnal");
        studentForm.submitForm();
        String verified=studentForm.verifyFormIsSubmitted();
        Assert.assertEquals(verified,"Thanks for submitting the form");
        Thread.sleep(5000);

    }
}
