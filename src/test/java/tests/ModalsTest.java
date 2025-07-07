package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ModalsPage;

/**
 * Tests the Modals page.
 */
public class ModalsTest extends BaseTest {
    private ModalsPage modalsPage;

    @BeforeClass
    public void setUp() {
        modalsPage = new ModalsPage();
        modalsPage.goToModalsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(modalsPage.getCurrentPageHeaderText(), "Modals", "Header text does not match!");
    }

    // Verify simple modal opens, shows correct text, and closes properly
    @Test(priority = 2)
    public void verifySimpleModal() {
        String actual = modalsPage.openSimpleModalAndGetTextThenClose();
        Assert.assertEquals(actual, "Simple Modal", "Simple modal text mismatch!");
    }

    // Verify form modal opens, shows correct text, filling forms and submits successfully
    @Test(priority = 3)
    public void verifyFormModal() {
        String actual = modalsPage.openFormModalAndGetText();
        Assert.assertEquals(actual, "Modal Containing A Form", "Form modal text mismatch!");
        modalsPage.fillAndSubmitFormModal();
    }
}