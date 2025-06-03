package demoqa.base;

import com.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.*;

import java.io.File;
import java.io.IOException;


public class BaseTest
{
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String url="https://demoqa.com/";



    @BeforeClass

    public void setUp() {
        WebDriver driver=this.driver;
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //implicit wait traje sve dok traje driver tj svaki put kad ga pozovomo svaki WebElement koristi wait
        //NIKAD NEMOJ DA KOMBINUJES VISE VRSTA CEKANJA MOZE DOCI DO ZBUNJIVANJA
    }

    @BeforeMethod
    public void loadApplication()   {
        // Inicijalizujte NOVI pregledač za SVAKI test
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        // Navigirajte na početnu URL i inicijalizujte Page Objects
        driver.get(url);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void takeFailTestSS(ITestResult testResult) throws IOException {
        if (ITestResult.FAILURE==testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source=screenshot.getScreenshotAs(OutputType.FILE);
            File destination=new File(System.getProperty("user.dir")+
                    "/resources/screenshots/(" +
                     java.time.LocalDate.now()+
                    testResult.getName()+ ".png"
                    );
            FileHandler.copy(source,destination);
        }if (driver != null) {
            driver.quit();
        }


    }


}
