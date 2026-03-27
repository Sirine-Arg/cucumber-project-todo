package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }


    private final By welcomeMessage = By.cssSelector("[data-testid=welcome]");
    private final By plusButton = By.xpath("//*[@id='root']/div[2]/div/div/div/button");
    private final By todoItems = By.xpath("//*[@id='root']/div[2]/div/div/div[2]");



    public boolean isWelcomeDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void clickPlusButton(){
        driver.findElement(plusButton).click();
    }

    public String getLastTodoText(){
        return driver.findElement(todoItems).getText();
    }
}
