package demoqa.tests.alertsframewind;

import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class FramesTest extends BaseTest {
    //kad se radi sa iframe-ovima dobra je praksa da se proveri da li smo se vratili na predhodni dom
    //tj da li smo izasli iz IFRAME!
    //npr assert da li je nasao header iz pocetne stranice/DOM-a
    @Test
    public void testFrameBigBox(){
       var frame =homePage.goToAlertsFrameWindows().clickOnFrame();
        String actual = frame.getTextFromBigFrame();
        Assert.assertEquals(actual,"This is a sample page");

    }
    @Test
    public void testFrameSmallBox(){
       var frame =homePage.goToAlertsFrameWindows().clickOnFrame();
        String actual = frame.getTextFromSmallFrameWebElement();
        Assert.assertEquals(actual,"This is a sample page");
        String originalDOM=frame.getHeaderFramesText();
        Assert.assertEquals(originalDOM,"Frames");

    }
}
