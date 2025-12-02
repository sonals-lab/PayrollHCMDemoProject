package base;

import Utilities.WaitUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    protected void click(WebElement element) {
        wait.waitForElementToBeClickable(element);
        element.click();
    }

    protected void type(WebElement element, String text) {
        wait.waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String jsGetTitle() {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
    }
}