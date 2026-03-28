package pageObject;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.EnvUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TodoPage extends BasePage {


    /* Locators */
    private static final String WELCOME_MESSAGE_CSS = "[data-testid='welcome']";
    private static final String PLUS_BUTTON_CSS = "[data-testid='add']";
    private static final String TODO_ITEMS_CSS = "[data-testid='todo-item']";
    private static final String DELETE_BUTTON_CSS = "[data-testid='delete']";
    private static final String NO_TODO_MESSAGE_CSS = "[data-testid='no-todos']";

    /* Constructor */
    public TodoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /* Elements */
    @FindBy(how = How.CSS, using = WELCOME_MESSAGE_CSS)
    private WebElement welcomeMessage;

    @FindBy(how = How.CSS, using = PLUS_BUTTON_CSS)
    private WebElement plusButton;

    @FindBy(how = How.CSS, using = TODO_ITEMS_CSS)
    private List<WebElement> todoItems;

    @FindBy(how = How.CSS, using = DELETE_BUTTON_CSS)
    private WebElement deleteButton;

    @FindBy(how = How.CSS, using = NO_TODO_MESSAGE_CSS)
    private WebElement noTodoMessage;

    /* Methods */

    public TodoPage load() throws IOException {
        driver.get(EnvUtils.getInstance().getURL() + "/TODO_PAGE_ENDPOINT");
        return this;
    }

    /**
     * Returns true if the welcome message is visible on the page.
     */
    public String getWelcomeMessageText() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.getText().trim();
    }

    /**
     * Clicks the plus button to add a new todo item.
     */
    public void clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
        new AddNewTodoPage(driver);
    }

    /**
     * Returns the text of the last todo item in the list.
     */
    public String getLastTodoText() {
        wait.until(ExpectedConditions.visibilityOfAllElements(todoItems));
        if (todoItems.isEmpty()) return null;
        return todoItems.getLast().getText();
    }

    /**
     * Deletes a todo item.
     */
    public TodoPage clickOnDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        return this;
    }

    /**
     * Checks if "no todos" message is displayed.
     */
    public boolean isNoTodosMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(noTodoMessage));
        return noTodoMessage.isDisplayed();
    }
}
