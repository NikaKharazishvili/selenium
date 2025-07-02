package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the Window Operations page.
 * Provides methods to navigate the page and interact with and test the behavior of opening a New Tab, replacing the current window, and opening a New Window.
 */
public class WindowOperationsPage extends BasePage {
    @FindBy(css = "a[href*='window-operations/']")
    WebElement windowOperationsLink;

    @FindBy(css = ".custom_btn[onclick='newTab()']")
    WebElement newTab;

    @FindBy(css = ".custom_btn[onclick='newWindowSelf()']")
    WebElement replaceWindow;

    @FindBy(css = ".custom_btn[onclick='newWindow()']")
    WebElement newWindow;

    public void goToWindowOperationsPage() {
        hoverAndClick(windowOperationsLink);
    }

    // Opens a new tab, captures its URL, closes it, and switches back to the original tab
    public String openNewTabAndGetUrl() {
        newTab.click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        String currentUrl = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(windows.get(0));
        return currentUrl;
    }

    // Replaces window, captures its URL, navigates back
    public String replaceWindowAndGetUrl() {
        replaceWindow.click();
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        return currentUrl;
    }

    // Opens a completely new browser window, captures its URL, closes it, and switches back to the original window
    public String openNewWindownAndGetUrl() {
        String originalWindow = driver.getWindowHandle();
        newWindow.click();

        // Wait until a new window appears
        Set<String> windowHandles = driver.getWindowHandles();
        while (windowHandles.size() == 1) {
            windowHandles = driver.getWindowHandles();
        }

        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(originalWindow);
        return currentUrl;
    }
}