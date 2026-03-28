package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObject.LoginPage;
import pageObject.TodoPage;
import utils.EnvUtils;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.GreetingUtils;
import utils.UserUtils;

import java.io.IOException;

public class UserSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage();
    TodoPage todoPage = new TodoPage(driver);

    @Given("User is at the login page")
    public void userIsAtTheLoginPage() throws IOException {
        loginPage.openLoginPage();
    }

    @When("User fills the email and the password and press login button")
    public void userFillsTheEmailAndThePasswordAndPressLoginButton() throws IOException {
        loginPage.login(
                EnvUtils.getInstance().getEmail(),
                EnvUtils.getInstance().getPassword()
        );
    }

    @Then("User is redirected to homepage and a welcome message is displayed")
    public void userIsRedirectedToHomePageAndAWelcomeMessageIsDisplayed() throws IOException {

        String actualMessage = todoPage.getWelcomeMessageText();

        String email = EnvUtils.getInstance().getEmail();
        String username = UserUtils.extractUsernameFromEmail(email);

        String expectedMessage = GreetingUtils.getExpectedGreeting(username);

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}