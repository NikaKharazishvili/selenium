package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.WindowOperationsPage;

/**
 * Tests the Window Operations page.
 */
public class WindowOperationsTest extends BaseTest {
    private WindowOperationsPage windowOperationsPage;
    private String expectedUrl = "https://automatenow.io/";

    @BeforeClass
    public void setUp() {
        windowOperationsPage = new WindowOperationsPage();
        windowOperationsPage.goToWindowOperationsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(windowOperationsPage.getCurrentPageHeaderText(), "Window Operations",
                "Header text does not match!");
    }

    // Verifies that a new tab opens correctly and navigates to the expected URL
    @Test(priority = 2)
    public void verifyNewTabOpensAndCloses() {
        String newTabUrl = windowOperationsPage.openNewTabAndGetUrl();
        Assert.assertEquals(newTabUrl, expectedUrl, "URL does not match!");
    }

    // Verifies that clicking the "Replace Window" button navigates to the expected URL and then returns back
    @Test(priority = 3)
    public void verifyWindowIsReplaced() {
        String newTabUrl = windowOperationsPage.replaceWindowAndGetUrl();
        Assert.assertEquals(newTabUrl, expectedUrl, "URL does not match!");
    }

    // Verifies that a completely new browser window opens correctly, navigates to the expected URL, and closes properly
    @Test(priority = 4)
    public void verifyNewWindowOpensAndCloses() {
        String newTabUrl = windowOperationsPage.openNewWindownAndGetUrl();
        Assert.assertEquals(newTabUrl, expectedUrl, "URL does not match!");
    }
}