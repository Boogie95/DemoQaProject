package demoqa.tests.widgets;

import com.pages.widgets.SelectMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

import java.util.List;

public class SelectDropDownTest extends BaseTest {

    @Test
    public void testMultiSelectDropDown() throws InterruptedException {

        homePage.goToWidgets().clickOnSelectMenu();
        SelectMenuPage selectMenuPage=new SelectMenuPage(driver);
        selectMenuPage.selectStandardMulti("Volvo");
        selectMenuPage.selectStandardMulti(1);
        selectMenuPage.selectStandardMulti(2);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.deselectStandardMulti("volvo");
        selectMenuPage.selectTitle("Prof.");
        List<String> actual =selectMenuPage.selectedOptionsList();
        Assert.assertTrue(actual.contains("Audi")&&actual.contains("Opel"));
    }
}
