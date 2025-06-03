package demoqa.tests.elements;

import com.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class LinksTest extends BaseTest {

    @Test
    public void testLinkShowMessage(){
        var linksPage=homePage.goToElements().clickOnLinks();
        linksPage.clickBadRequestLink();
        String actual=linksPage.getResponse();
        Assert.assertTrue(actual.contains("400")&&actual.contains("Bad Request"));
    }
    @Test
    public void testLinkOpenNewTab() throws InterruptedException {
        LinksPage linksPage=homePage.goToElements().clickOnLinks();
        linksPage.clickHomePageNewTab();
        Assert.assertTrue(homePage.isElementDisplayed(homePage.homePageBanner));
    }

}
