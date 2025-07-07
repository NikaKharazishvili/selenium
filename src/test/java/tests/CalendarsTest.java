package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CalendarsPage;

/**
 * Tests the Calendars page.
 */
public class CalendarsTest extends BaseTest {
    private CalendarsPage calendarsPage;

    @BeforeClass
    public void setUp() {
        calendarsPage = new CalendarsPage();
        calendarsPage.goToCalendarsPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(calendarsPage.getCurrentPageHeaderText(), "Calendars", "Header text does not match!");
    }

    // Tests selecting a specific date in the calendar input and verifies the value is correctly set
    @Test(priority = 2)
    public void verifyDateSelection() {
        int year = 2000, month = 12, day = 12;
        calendarsPage.setDate(year, month, day);
        Assert.assertEquals(calendarsPage.getDate(), year + "-" + month + "-" + day, "Date text does not match!");
    }
}