package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Gestures page.
 * Provides methods to navigate the page and perform gestures actions.
 */
public class GesturesPage extends BasePage {
    @FindBy(css = "a[href*='gestures/']")
    WebElement gesturesLink;

    @FindBy(id = "moveMeHeader")
    WebElement boxHeader;

    @FindBy(css = "img[data-recalc-dims='1']")
    WebElement image;

    @FindBy(id = "div2")
    WebElement imagePlaceToMove;

    public void goToGesturesPage() {
        hoverAndClick(gesturesLink);
    }

    public GesturesPage moveBox() {
        actions.clickAndHold(boxHeader)
                .moveByOffset(500, 100)
                .release()
                .perform();
        return this;
    }

    public GesturesPage dragAndDropImage() {
        actions.dragAndDrop(image, imagePlaceToMove).perform();
        return this;
    }
}