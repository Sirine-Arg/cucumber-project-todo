package hooks;

import factoryNavigator.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver(); // ✅ THIS FIXES YOUR ERROR
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}