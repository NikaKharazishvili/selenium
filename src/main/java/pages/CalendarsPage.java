package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Page Object for the Calendars page.
 * Provides methods to navigate the page and select date.
 */
public class CalendarsPage extends BasePage {
    @FindBy(css = "a[href*='calendars/']")
    private WebElement calendarLink;

    @FindBy(id = "g1065-2-1-selectorenteradate")
    private WebElement datePicker;

    public void goToCalendarsPage() {
        hoverAndClick(calendarLink);
    }

    public void setDate(int year, int month, int day) {
        // Format the date correctly (YYYY-MM-DD)
        String date = year + "-" + month + "-" + day;

        // Set the date value using JavaScript and trigger an input event
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'))",
                datePicker, date);
    }

    public String getDate() {
        return datePicker.getDomProperty("value");
    }
}