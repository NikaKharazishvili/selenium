package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HoverPage;

/**
 * Tests the Hover page.
 */
public class HoverTest extends BaseTest {
    private HoverPage hoverPage;

    @BeforeClass
    public void setUp() {
        hoverPage = new HoverPage();
        hoverPage.goToHoverPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(hoverPage.getCurrentPageHeaderText(), "Hover", "Header text does not match!");
    }

    // Verifies the text changes correctly after hovering over the element
    @Test(priority = 2)
    public void verifyHoverWorks() {
        String initialText = hoverPage.getTextBeforeHover();
        Assert.assertEquals(initialText, "Mouse over me", "Hover text does not match!");
        String changedText = hoverPage.hoverAndGetText();
        Assert.assertEquals(changedText, "You did it!", "Hover text does not match!");
    }
}