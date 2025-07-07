package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object for the Sliders page.
 * Provides methods to navigate the page and move slider.
 */
public class SliderPage extends BasePage {
    @FindBy(css = "a[href*='slider']")
    private WebElement sliderLink;

    @FindBy(id = "slideMe")
    private WebElement slider;

    public void goToSliderPage() {
        hoverAndClick(sliderLink);
    }

    // Set slider value using JavaScript and trigger an input event
    public void moveSlider(int targetValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'))",
                slider,
                targetValue);
    }

    public int getSliderValue() {
        return Integer.parseInt(slider.getDomProperty("value"));
    }
}