package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility extends Utility{

    public ActionsUtility(WebDriver driver) {
        super(driver);
    }

    private  Actions act(){
        return new Actions(driver);
    }
    public void dragAndDropBy(WebElement source,int x,int y){
        act().dragAndDropBy(source,x,y).perform();
    }
}
