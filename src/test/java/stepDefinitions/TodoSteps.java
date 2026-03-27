package stepDefinitions;

import factoryNavigator.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.AddNewTodoPage;
import pageObject.LoginPage;
import pageObject.TodoPage;
import utils.EnvUtils;

import java.io.IOException;

public class TodoSteps {

    WebDriver driver;

    @Given("User is in the todos page")
    public void userIsInTheTodosPage() throws IOException {
        driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load(EnvUtils.getInstance().getURL() +"/login");
        loginPage.login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }

    @When("User adds a new todo")
    public void userAddsANewTodo(){
        new TodoPage(driver).clickPlusButton();
        new AddNewTodoPage(driver).addTodo("LearnCucumber");
    }



    @Then("todo is be added correctly")
    public void todoIsBeAddedCorrectly(){
        String text = new TodoPage(driver).getLastTodoText();
        Assert.assertEquals(text, "Learn Cucumber");
    }



}
