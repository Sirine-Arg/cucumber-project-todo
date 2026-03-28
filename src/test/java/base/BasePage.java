package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import factoryNavigator.DriverFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    public BasePage() {
        this.driver = DriverFactory.getDriver(); // ✅ safe, initializes if null
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void load(String url) {
        driver.get(url);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}