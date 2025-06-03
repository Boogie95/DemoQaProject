package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertsUtitility extends Utility{


    public AlertsUtitility(WebDriver driver) {
        super(driver);
    }

    public static Alert switchAlert(){
          return driver.switchTo().alert();
    }
    public String getTextAlertBox(){
        return switchAlert().getText();
    }
    public static void alertOk(){
        switchAlert().accept();
    }
    public static void alertCancel(){
        switchAlert().dismiss();
    }
    public static void insertPromptText(String name){
        switchAlert().sendKeys(name);
    }

}
