package tests;

import core.ConfigReader;
import core.DriverManager;
import pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Base test setup and teardown for WebDriver.
 */
public class BaseTest {
    // Ensures that after all tests in the class, the browser navigates back to the homepage to start another page test
    @AfterClass
    public void goToHomePage() {
        new BasePage().goToHomePage();
    }

    // Sets up WebDriver, navigates to URL, and maximizes window before tests
    @BeforeSuite
    public void setUp() {
        String browser = ConfigReader.get("browser").toLowerCase();
        WebDriver driver;

        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        DriverManager.setDriver(driver);
        driver.get(ConfigReader.get("url"));
        driver.manage().window().maximize();
    }

    // Closes the browser and quits WebDriver after all tests
    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }
}