
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayrollDashboardPage {

    private WebDriver driver;

    private By runPayrollBtn = By.id("runPayroll");
    private By status = By.id("payrollStatus");

    public PayrollDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRunPayroll() {
        driver.findElement(runPayrollBtn).click();
    }

    public String getPayrollStatus() {
        return driver.findElement(status).getText();
    }
}
