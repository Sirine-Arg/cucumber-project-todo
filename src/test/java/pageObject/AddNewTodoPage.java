package pageObject;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewTodoPage extends BasePage {

    /* Locators */
    private static final String NEW_TODO_INPUT_CSS = "[data-testid='new-todo']";
    private static final String NEW_TODO_BUTTON_CSS = "[data-testid='submit-newTask']";

    /* Constructor */
    public AddNewTodoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /* Elements */
    @FindBy(how = How.CSS, using = NEW_TODO_INPUT_CSS)
    private WebElement newTodoInput;

    @FindBy(how = How.CSS, using = NEW_TODO_BUTTON_CSS)
    private WebElement newTodoButton;

    /* Methods */

    /**
     * Adds a new todo item.
     */
    public void addTodo(String item) {
        wait.until(ExpectedConditions.visibilityOf(newTodoInput)).sendKeys(item);
        wait.until(ExpectedConditions.elementToBeClickable(newTodoButton)).click();
    }
}