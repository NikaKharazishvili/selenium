package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GesturesPage;

/**
 * Tests the Gestures page.
 */
public class GesturesTest extends BaseTest {
    private GesturesPage gesturesPage;

    @BeforeClass
    public void setUp() {
        gesturesPage = new GesturesPage();
        gesturesPage.goToGesturesPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(gesturesPage.getCurrentPageHeaderText(), "Gestures", "Header text does not match!");
    }

    // Performs the gestures actions but does NOT assert. Intended for visual/manual confirmation only
    @Test(priority = 2)
    public void performGesturesActions() {
        gesturesPage
                .moveBox()
                .dragAndDropImage();
    }
}