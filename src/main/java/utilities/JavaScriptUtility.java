package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class JavaScriptUtility extends Utility{

    public JavaScriptUtility(WebDriver driver) {
        super(driver);
    }

    public static void scrollToElementJS(By locator){
        WebElement element=driver.findElement(locator);
        String jsScript="arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript,element);
    }

    public static void clickJS(By locator){
        WebElement element=driver.findElement(locator);
        String jsScript="arguments[0].click();";
        ((JavascriptExecutor)driver).executeScript(jsScript,element);
    }

    public void openNewTab()  {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://demoqa.com/");
    }




}
