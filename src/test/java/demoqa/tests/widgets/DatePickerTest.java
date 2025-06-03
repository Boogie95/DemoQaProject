package demoqa.tests.widgets;
import com.pages.widgets.DatePickerMenu;
import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

public class DatePickerTest extends BaseTest {
    @Test
    public void selectDateTest(){
        homePage.goToWidgets().clickOnDatePickerMenu();
        DatePickerMenu datePickerMenu=new DatePickerMenu(driver);
        datePickerMenu.selectMonthDropDown("September");
        datePickerMenu.selectYearDropDown("2002");
        datePickerMenu.setDayDropDown("20");
        String actual=datePickerMenu.getValueFromInput();
        Assert.assertTrue(actual.contains("20")&&actual.contains("9")&&actual.contains("2002"));
    }
}
