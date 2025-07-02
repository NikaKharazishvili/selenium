package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Popups page.
 * Provides methods to navigate the page and interact with alert, confirm, and prompt popups.
 */
public class PopupsPage extends BasePage {
    @FindBy(css = "a[href*='popups']")
    private WebElement popupsLink;

    @FindBy(id = "alert")
    private WebElement alertPopup;

    @FindBy(id = "confirm")
    private WebElement confirmPopup;

    @FindBy(id = "prompt")
    private WebElement promptPopup;

    @FindBy(id = "confirmResult")
    private WebElement confirmPopupText;

    @FindBy(id = "promptResult")
    private WebElement promptPopupText;

    public void goToPopupsPage() {
        popupsLink.click();
    }

    public void clickAlertPopup() {
        alertPopup.click();
    }

    public void clickConfirmPopup() {
        confirmPopup.click();
    }

    public String getConfirmPopupText() {
        return confirmPopupText.getText();
    }

    public void clickPromptPopup() {
        promptPopup.click();
    }

    public String getPromptPopupText() {
        return promptPopupText.getText();
    }
}