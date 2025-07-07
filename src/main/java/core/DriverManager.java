package core;

import org.openqa.selenium.WebDriver;

/**
 * Manages WebDriver instances using ThreadLocal to ensure thread-safe execution
 * in parallel Selenium tests. Each thread gets its own WebDriver instance, 
 * preventing conflicts during test setup and teardown.
 */
public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}