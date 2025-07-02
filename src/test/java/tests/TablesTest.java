package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.TablesPage;

/**
 * Tests the Tables page.
 */
public class TablesTest extends BaseTest {
    private TablesPage tablesPage;

    @BeforeClass
    public void setUp() {
        tablesPage = new TablesPage();
        tablesPage.goToTablesPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(tablesPage.getCurrentPageHeaderText(), "Tables", "Header text does not match!");
    }

    // Verifies that the displayed items and their prices match the expected values in the table
    @Test(priority = 2)
    public void verifyItemsPrices() {
        Map<String, String> actual = tablesPage.getDisplayedItemsAndPrices();
        Map<String, String> expected = Map.of(
                "Oranges", "$3.99",
                "Laptop", "$1200.00",
                "Marbles", "$1.25");
        Assert.assertEquals(actual, expected, "Items and prices on the table do not match expected values!");
    }
}