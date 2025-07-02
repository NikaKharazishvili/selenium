package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the JavaScript Delays page.
 * Provides methods to navigate the page, start the countdown, and wait for the text to change to "Liftoff!".
 */
public class DelaysPage extends BasePage {
    @FindBy(css = "a[href*='javascript-delays']")
    private WebElement delaysButton;

    @FindBy(id = "start")
    private WebElement startButton;

    @FindBy(id = "delay")
    private WebElement countdown;

    public void goToDelaysPage() {
        waitClick(delaysButton);
    }

    public void startCountdown() {
        waitClick(startButton);
        waitForTextToBe(countdown, "Liftoff!", 15);
    }

    public String getCountdownText() {
        return countdown.getText();
    }
}