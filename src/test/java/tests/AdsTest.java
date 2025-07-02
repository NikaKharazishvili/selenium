package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdsPage;

/**
 * Tests the Ads page.
 */
public class AdsTest extends BaseTest {
    private AdsPage adsPage;

    @BeforeClass
    public void setUp() {
        adsPage = new AdsPage();
        adsPage.goToAdsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(adsPage.getCurrentPageHeaderText(), "Ads", "Header text does not match!");
    }

    // Verifies that the ad appears with the correct text.
    @Test(priority = 2)
    public void verifyAd() {
        adsPage.waitForAdToAppear();
        String actualTextFromAd = adsPage.getTextFromAdAndCloseIt();
        String expectedTextFromAd = "I am an ad.";
        Assert.assertEquals(actualTextFromAd, expectedTextFromAd);
    }
}