package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.ConfigReader;
import pages.FormFieldsPage;

/**
 * Tests the FormFields page.
 */
public class FormFieldsTest extends BaseTest {
    private FormFieldsPage formFieldsPage;

    @BeforeClass
    public void setUp() {
        formFieldsPage = new FormFieldsPage();
        formFieldsPage.goToFormFieldsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(formFieldsPage.getCurrentPageHeaderText(), "Form Fields", "Header text does not match!");
    }

    // Fill out and submit the form with data from the ConfigReader
    @Test(priority = 2)
    public void fillFields() {
        formFieldsPage
                .fillForms(ConfigReader.get("name"),
                        ConfigReader.get("password"),
                        ConfigReader.get("favDrink"),
                        Integer.parseInt(ConfigReader.get("favColorIndex")),
                        ConfigReader.get("doYouLikeAutomation"),
                        ConfigReader.get("email"),
                        ConfigReader.get("text"))
                .clickSubmit();
    }

    // Accept the alert after submitting the form
    @Test(priority = 3)
    public void acceptAlert() {
        Assert.assertEquals(formFieldsPage.getAlertText(), "Message received!", "Alert text does not match!");
        formFieldsPage.acceptAlert();
    }
}