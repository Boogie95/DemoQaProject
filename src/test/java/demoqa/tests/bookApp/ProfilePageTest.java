package demoqa.tests.bookApp;

import demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest {
    @Test
    public void goToLoginThrowProfilTest(){
        var profilePage=homePage.goToBookStoreApp().goToProfilePage();
        var loginPage=profilePage.goToLoginPage();
        String actual=loginPage.verifyImOnLoginPage();
        Assert.assertEquals(actual,"Login in Book Store");
    }
    @Test
    public void goToRegisterThrowProfileTest(){
        var profilePage=homePage.goToBookStoreApp().goToProfilePage();
        var registerPage=profilePage.goToRegisterPage();
        String actual=registerPage.verifyImOnRegisterPage();
        Assert.assertEquals(actual,"Register");
    }
}
