package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObject.AddNewTodoPage;
import pageObject.LoginPage;
import pageObject.TodoPage;
import utils.EnvUtils;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.GreetingUtils;
import utils.TestContext;

import java.io.IOException;

public class TodoSteps {

    WebDriver driver = DriverManager.getDriver();
    TestContext context;

    public TodoSteps(TestContext context) {
        this.context = context;
    }

    LoginPage loginPage;
    AddNewTodoPage addNewTodoPage;

    @Given("User navigates to login page")
    public void userNavigatesToTheLoginPage() throws Exception {
        loginPage = new LoginPage(); // ✅ FIX
        loginPage.openLoginPage();
    }

    @When("User logs in")
    public void userLogsIn() throws Exception {
        loginPage.login(   // ✅ capture returned page
                EnvUtils.getInstance().getEmail(),
                EnvUtils.getInstance().getPassword()
        );
    }

    @Then("User should see welcome message")
    public void userShouldSeeWelcomeMessage() throws IOException {

        String actualMessage = context.todoPage.getWelcomeMessageText();

        String username = EnvUtils.getInstance().getFormattedUsername(); // make sure exists
        String expectedMessage = GreetingUtils.getExpectedGreeting(username);

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Welcome message is incorrect"
        );
    }

    @When("User adds a new todo")
    public void userAddsANewTodo() {
        context.todoPage.clickPlusButton(); // ✅ capture page
        addNewTodoPage.addTodo("Learn cucumber"); // ✅ return to TodoPage
    }

    @Then("Todo should be added")
    public void todoShouldBeAdded() {
        String lastTodo = context.todoPage.getLastTodoText();

        Assert.assertEquals(lastTodo, "Learn cucumber");
    }
}