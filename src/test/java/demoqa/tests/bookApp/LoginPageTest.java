package demoqa.tests.bookApp;

import com.pages.bookstore.ProfilePage;
import data.TestData;
import demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test
    public void existingUserloggingIn(){
        var loginPage=homePage.goToBookStoreApp().loggin();
        ProfilePage profilePage=new ProfilePage(driver);
        loginPage.login("testuser","Test@123");
        String actual=profilePage.getUserValue();
        Assert.assertEquals(actual,"testuser");
    }
    @Test
    public void logOutExistsUser(){
        var loginPage=homePage.goToBookStoreApp().loggin();
        ProfilePage profilePage=new ProfilePage(driver);
        loginPage.login("testuser","Test@123");
        profilePage.logoutFromProfile();
        String actual=loginPage.verifyImOnLoginPage();
        Assert.assertEquals(actual,"Login in Book Store");
    }
    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void invalidLoginTest(String username,String pass,boolean expectErrorMessage,boolean expectInvalidFields){
        var loginPage = homePage.goToBookStoreApp().loggin();
        loginPage.login(username, pass);
        if (expectErrorMessage) {
            Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        }
        if (expectInvalidFields) {
            if (username.isBlank()) {
                Assert.assertTrue(loginPage.isUsernameFieldInvalid());
            }
            if (pass.isBlank()) {
                Assert.assertTrue(loginPage.isPasswordFieldInvalid());
            }
        }
        Assert.assertTrue(loginPage.isStillOnLoginPage());
    }
}


