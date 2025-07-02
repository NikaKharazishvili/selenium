package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Ads page.
 * Provides methods to navigate the page, wait for the ad to appear, and close it.
 */
public class AdsPage extends BasePage {
    @FindBy(css = "a[href*='ads/']")
    WebElement adsLink;

    @FindBy(id = "popmake-1272")
    WebElement adElement;

    @FindBy(css = "#popmake-1272 .pum-content p")
    WebElement adContentParagraph;

    @FindBy(css = "#popmake-1272 .pum-close")
    WebElement adCloseButton;

    public void goToAdsPage() {
        hoverAndClick(adsLink);
    }

    public void waitForAdToAppear() {
        waitForElementVisible(adElement);
    }

    public String getTextFromAdAndCloseIt() {
        String text = adContentParagraph.getText();
        adCloseButton.click();
        return text;
    }
}