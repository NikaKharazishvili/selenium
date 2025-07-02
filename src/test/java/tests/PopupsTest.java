package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.PopupsPage;

/**
 * Tests the Popups page.
 */
public class PopupsTest extends BaseTest {
    private PopupsPage popupsPage;

    @BeforeClass
    public void setUp() {
        popupsPage = new PopupsPage();
        popupsPage.goToPopupsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(popupsPage.getCurrentPageHeaderText(), "Popups", "Header text does not match!");
    }

    // Test simple alert popup and accept it
    @Test(priority = 2)
    public void testAlertPopup() {
        popupsPage.clickAlertPopup();
        Assert.assertEquals(popupsPage.getAlertText(), "Hi there, pal!", "Alert text does not match!");
        popupsPage.acceptAlert();
    }

    // Test confirm popup: accept and dismiss scenarios
    @Test(priority = 3)
    public void testConfirmPopup() {
        popupsPage.clickConfirmPopup();
        Assert.assertEquals(popupsPage.getAlertText(), "OK or Cancel, which will it be?", "Alert text does not match!");
        popupsPage.acceptAlert();
        Assert.assertEquals(popupsPage.getConfirmPopupText(), "OK it is!", "Popup text does not match!");

        popupsPage.clickConfirmPopup();
        Assert.assertEquals(popupsPage.getAlertText(), "OK or Cancel, which will it be?", "Alert text does not match!");
        popupsPage.dismissAlert();
        Assert.assertEquals(popupsPage.getConfirmPopupText(), "Cancel it is!", "Popup text does not match!");
    }

    // Test prompt popup: input text and accept, then dismiss without input
    @Test(priority = 4)
    public void testPromptPopup() {
        popupsPage.clickPromptPopup();
        Assert.assertEquals(popupsPage.getAlertText(), "Hi there, what's your name?", "Alert text does not match!");
        popupsPage.sendTextToAlert("Aham Brahmasmi");
        popupsPage.acceptAlert();
        Assert.assertEquals(popupsPage.getPromptPopupText(), "Nice to meet you, Aham Brahmasmi!", "Prompt text does not match!");

        popupsPage.clickPromptPopup();
        Assert.assertEquals(popupsPage.getAlertText(), "Hi there, what's your name?", "Alert text does not match!");
        popupsPage.dismissAlert();
        Assert.assertEquals(popupsPage.getPromptPopupText(), "Fine, be that way...", "Prompt text does not match!");
    }
}