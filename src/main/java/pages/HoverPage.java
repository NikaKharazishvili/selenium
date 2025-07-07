package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Hover page.
 * Handles navigation and hover interaction for verifying dynamic text changes.
 */
public class HoverPage extends BasePage {
    @FindBy(css = "a[href*='hover/']")
    WebElement hoverLink;

    @FindBy(id = "mouse_over")
    WebElement elementToHover;

    public void goToHoverPage() {
        hoverAndClick(hoverLink);
    }

    public String getTextBeforeHover() {
        return elementToHover.getText();
    }

    public String hoverAndGetText() {
        hover(elementToHover);
        return elementToHover.getText();
    }
}