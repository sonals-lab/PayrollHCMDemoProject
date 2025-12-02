package base;

import Config.configReader;
import Config.envManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected configReader.ConfigReader config;
    protected envManager.EnvManager envManager;

    @BeforeClass(alwaysRun = true)
    public void setUp() {

        // Load config file
        config = new configReader.ConfigReader("src/test/resources/config.properties");
        envManager = new envManager();

        // Chrome setup
        System.setProperty("webdriver.chrome.driver",
                config.get("chrome.driver.path", "./drivers/chromedriver"));

        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(config.get("headless", "false"))) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // Navigate to base URL
        String env = config.get("env", "dev");
        String baseUrl = envManager.getBaseUrl(env);
        driver.get(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
