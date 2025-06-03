package utilities;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {

    protected static WebDriver driver;

    public Utility(WebDriver driver){
        this.driver = driver;
        // Inicijalizujte čekanje
    }

    // Primeri generičkih metoda za čekanje i akcije
    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) { // Generički klik
        waitForElementToBeClickable(locator); // Koristi metodu iz iste klase
        driver.findElement(locator).click();
    }

    public void clickWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
