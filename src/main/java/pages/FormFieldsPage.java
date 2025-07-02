package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object for the FormFields page.
 * Provides methods to navigate the page and fill forms.
 */
public class FormFieldsPage extends BasePage {
    @FindBy(css = "a[href*='form-fields']")
    private WebElement formFieldsLink;

    @FindBy(id = "name-input")
    private WebElement nameInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(name = "fav_drink")
    private List<WebElement> favouriteDrinks;

    @FindBy(name = "fav_color")
    private List<WebElement> favouriteColors;

    @FindBy(id = "automation")
    private WebElement automationQuestionDropdown;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(id = "submit-btn")
    private WebElement submitButton;

    public void goToFormFieldsPage() {
        waitClick(formFieldsLink);
    }

    public FormFieldsPage fillForms(String name, String password, String favDrink, int favColorIndex,
            String doYouLikeAutomation, String email, String message) {
        nameInput.sendKeys(name);
        passwordInput.sendKeys(password);

        // Select a favorite drink by text
        boolean found = false;
        for (WebElement drink : favouriteDrinks) {
            if (drink.getDomAttribute("value").equals(favDrink)) {
                drink.click();
                found = true;
                break;
            }
        }
        if (!found)
            throw new RuntimeException("Drink not found: " + favDrink);

        // Select a favorite color by index (must be within range). Hover on it and then click
        if (favColorIndex >= 0 && favColorIndex < 5)
            hoverAndClick(favouriteColors.get(favColorIndex));
        else
            throw new IllegalArgumentException("Invalid color index: " + favColorIndex);

        // Select dropdown by text
        new Select(automationQuestionDropdown).selectByVisibleText(doYouLikeAutomation);

        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
        return this;
    }

    public FormFieldsPage clickSubmit() {
        hoverAndClick(submitButton);
        return this;
    }
}