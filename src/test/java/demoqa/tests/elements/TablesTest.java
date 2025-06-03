package demoqa.tests.elements;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import demoqa.base.BaseTest;

import java.util.List;

public class TablesTest extends BaseTest {

    @Test
    public void editUserUsingEmail()  {
        var webTablesPage=homePage.goToElements().clikcPracticeWebTables();
        webTablesPage.clickEdit("kierra@example.com");
        webTablesPage.setAge("34");
        webTablesPage.clickSubmit();
        String actual=webTablesPage.getTableAge("kierra@example.com");
        Assert.assertEquals(actual,"34" );
    }
   @Test
    public void addNewRowTest(){
        var webTablesPage=homePage.goToElements().clikcPracticeWebTables();
        List<WebElement> numberOfRowsBefore = webTablesPage.getRows();
        webTablesPage.addNewRowIntoTable("Jovan","bundalo","jovan.bundalo.95@gmail.com","30","20000","computer science");
        List<WebElement> numberOfRowsAfter = webTablesPage.getRows();
        Assert.assertEquals(numberOfRowsAfter.size(), numberOfRowsBefore.size() + 1);
   }
   @Test
    public void deleteExistingRowTest(){
       var webTablesPage=homePage.goToElements().clikcPracticeWebTables();
       List<WebElement> numberOfRowsBefore = webTablesPage.getRows();
       webTablesPage.deleteRow("alden@example.com");
       List<WebElement> numberOfRowsAfter = webTablesPage.getRows();
       Assert.assertEquals(numberOfRowsAfter.size(), numberOfRowsBefore.size() - 1);


   }

}
