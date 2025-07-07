package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Tables page.
 * Provides methods to navigate the page and retrieve items and their prices.
 */
public class TablesPage extends BasePage {
    @FindBy(css = "a[href*='tables/']")
    private WebElement tablesLink;

    @FindBy(css = ".wp-block-table table tbody tr td:first-child")
    private List<WebElement> items;

    @FindBy(css = ".wp-block-table table tbody tr td:last-child")
    private List<WebElement> prices;

    public void goToTablesPage() {
        hoverAndClick(tablesLink);
    }

    public Map<String, String> getDisplayedItemsAndPrices() {
        Map<String, String> displayedMap = new java.util.LinkedHashMap<>();

        for (int i = 1; i < items.size(); i++) { // skip index 0 (header)
            String item = items.get(i).getText().trim();
            String price = prices.get(i).getText().trim();
            displayedMap.put(item, price);
        }
        return displayedMap;
    }
}