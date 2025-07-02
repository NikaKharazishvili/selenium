package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DelaysPage;

/**
 * Tests the JavaScript Delays page.
 */
public class DelaysTest extends BaseTest {
    private DelaysPage delaysPage;

    @BeforeClass
    public void setUp() {
        delaysPage = new DelaysPage();
        delaysPage.goToDelaysPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(delaysPage.getCurrentPageHeaderText(), "JavaScript Delays");
    }

    // Start the countdown and verify it ends with "Liftoff!"
    @Test(priority = 2)
    public void testDelaysPage() {
        delaysPage.startCountdown();
        Assert.assertEquals(delaysPage.getCountdownText(), "Liftoff!");
    }
}