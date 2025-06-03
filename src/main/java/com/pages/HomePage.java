package com.pages;

import com.base.BasePage;
import com.pages.alertsframewindows.AlertsFrameWindowsPage;
import com.pages.bookstore.BookStorePage;
import com.pages.elements.ElementsPage;
import com.pages.widgets.WidgtesPage;
import org.openqa.selenium.By;
import com.pages.forms.FormsPages;
import org.openqa.selenium.WebDriver;
import utilities.JavaScriptUtility;


public class HomePage extends BasePage {

        private By formsCards= By.xpath("//div[@class='card-body']//h5[text()='Forms']");
        public By elementsCard= By.xpath("//div[@class='card-body']//h5[text()='Elements']");
        public By widgetsCard= By.xpath("//div[@class='card-body']//h5[text()='Widgets']");
        public By alertsFrameWindows=By.xpath("//div[@id='app']//h5[contains(text(),'Alerts')]");
        public By bookStoreApp=By.xpath("//div[@id='app']//h5[contains(text(),'Book Store')]");
        public By homePageBanner=By.className("home-banner");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FormsPages goToForms() {
            JavaScriptUtility.scrollToElementJS(elementsCard);
            click(formsCards);
            return new FormsPages(driver);
        }

    public ElementsPage goToElements() {
        JavaScriptUtility.scrollToElementJS(elementsCard);
        waitForElementToBeClickable(elementsCard);
        click(elementsCard);
        return new ElementsPage(driver);
    }
    public WidgtesPage goToWidgets() {
        JavaScriptUtility.scrollToElementJS(widgetsCard);
        waitForElementToBeClickable(widgetsCard);
        click(widgetsCard);
        return new WidgtesPage(driver);
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindows(){
            JavaScriptUtility.scrollToElementJS(alertsFrameWindows);
            waitForElementToBeClickable(alertsFrameWindows);
            click(alertsFrameWindows);
            return new AlertsFrameWindowsPage(driver);
    }
    public BookStorePage goToBookStoreApp(){
            JavaScriptUtility.scrollToElementJS(bookStoreApp);
            waitForElementToBeClickable(bookStoreApp);
            click(bookStoreApp);
            return new BookStorePage(driver);
    }






}
