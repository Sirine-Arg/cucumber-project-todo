package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.EnvUtils;

import java.io.IOException;

public class LoginPage extends BasePage {

    /* Locators */
    private static final String EMAIL_INPUT_CSS = "[data-testid='email']";
    private static final String PASSWORD_INPUT_CSS = "[data-testid='password']";
    private static final String SUBMIT_BUTTON_CSS = "[data-testid='submit']";

    /* FindBy */
    @FindBy(how = How.CSS, using = EMAIL_INPUT_CSS)
    private WebElement emailInput;

    @FindBy(how = How.CSS, using = PASSWORD_INPUT_CSS)
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = SUBMIT_BUTTON_CSS)
    private WebElement submitButton;

    // Constructor
    public LoginPage() {
        super(); // ensures driver is initialized in BasePage
        PageFactory.initElements(driver, this); // <-- Initialize WebElements
    }

    /* Methods */
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        submitButton.click();
    }

    // Method to load the login page
    public void openLoginPage() throws IOException {
        String url = EnvUtils.getInstance().getURL() + "/login";
        driver.get(url);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}