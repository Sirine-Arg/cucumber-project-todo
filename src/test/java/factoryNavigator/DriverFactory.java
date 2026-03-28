package factoryNavigator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageObject.LoginPage;

public class DriverFactory {

    // ThreadLocal ensures each thread/test has its own driver instance
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    // Get driver, initialize if not already done
    public static WebDriver getDriver() {
        if (driverThread.get() == null) {
            initDriver();
        }
        return driverThread.get();
    }

    // Initialize driver based on system property "browser"
    public static void initDriver() {
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
        WebDriver driver;

        switch (browser) {
            case "FIREFOX" -> driver = new FirefoxDriver();
            case "EDGE" -> driver = new EdgeDriver();
            case "SAFARI" -> driver = new SafariDriver();
            default -> driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driverThread.set(driver);
    }

    // Quit driver and remove from ThreadLocal
    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }


}