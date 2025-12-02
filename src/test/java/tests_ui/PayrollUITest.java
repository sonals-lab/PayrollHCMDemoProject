
package tests_ui;

import base.BaseTest;
import pages.LoginPage;
import pages.PayrollDashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayrollUITest extends BaseTest {

    @Test
    public void testPayrollExecution() {
        driver.get("https://dummy-payroll-app.com/login");

        LoginPage login = new LoginPage(driver);
        login.enterEmail("test@company.com");
        login.enterPassword("password123");
        login.clickLogin();

        PayrollDashboardPage payroll = new PayrollDashboardPage(driver);
        payroll.clickRunPayroll();

        Assert.assertEquals(payroll.getPayrollStatus(), "Completed");
    }
}
