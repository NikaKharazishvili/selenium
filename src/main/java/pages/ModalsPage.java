package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.ConfigReader;

/**
 * Page Object for the Modals page.
 * Provides methods to navigate the page and interact with modals.
 */
public class ModalsPage extends BasePage {
    @FindBy(css = "a[href*='modals/']")
    private WebElement modalsLink;

    @FindBy(id = "simpleModal")
    private WebElement simpleModal;

    @FindBy(id = "pum_popup_title_1318")
    private WebElement simpleModalText;

    @FindBy(css = "#popmake-1318 .pum-close.popmake-close")
    private WebElement simpleModalCloseButton;

    @FindBy(id = "formModal")
    private WebElement formModal;

    @FindBy(id = "pum_popup_title_674")
    private WebElement formModalText;

    @FindBy(id = "g1051-name")
    private WebElement formModalNameInput;

    @FindBy(id = "g1051-email")
    private WebElement formModalEmailInput;

    @FindBy(id = "contact-form-comment-g1051-message")
    private WebElement formModalMessageInput;

    @FindBy(css = ".pushbutton-wide")
    private WebElement formModalSubmitButton;

    public void goToModalsPage() {
        hoverAndClick(modalsLink);
    }

    public String openSimpleModalAndGetTextThenClose() {
        simpleModal.click();
        waitForTextToBe(simpleModalText, "Simple Modal", 3);
        String text = simpleModalText.getText();
        simpleModalCloseButton.click();
        return text;
    }

    public String openFormModalAndGetText() {
        formModal.click();
        waitForTextToBe(formModalText, "Modal Containing A Form", 3);
        String text = formModalText.getText();
        return text;
    }

    public void fillAndSubmitFormModal() {
        formModalNameInput.sendKeys(ConfigReader.get("name"));
        formModalEmailInput.sendKeys(ConfigReader.get("email"));
        formModalMessageInput.sendKeys(ConfigReader.get("text"));
        formModalSubmitButton.click();
    }
}