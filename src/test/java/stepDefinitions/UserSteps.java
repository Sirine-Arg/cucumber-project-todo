package stepDefinitions;

import factoryNavigator.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LoginPage;
import pageObject.TodoPage;
import utils.EnvUtils;

import java.io.IOException;

public class UserSteps {

    WebDriver driver;

    @Given("User is at the login page")
    public void userIsAtTheLoginPage() throws IOException {
        driver = DriverFactory.getDriver();
        new LoginPage(driver).load(EnvUtils.getInstance().getURL() +"/login");
    }

    @When("User fills the email and the password and press login button")
    public void userFillsTheEmail() throws IOException {
        new LoginPage(driver).login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }



    @Then("User is redirected to homepage and a welcome message is displayed")
    public void userIsRedirectedToHomePageAndAWelcomeMessageIsDisplayed(){
        boolean isWelcomeDisplayed = new TodoPage(driver).isWelcomeDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }

}
