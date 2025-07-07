package tests;

import pages.SliderPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests the Sliders page.
 */
public class SliderTest extends BaseTest {
    private SliderPage sliderPage;

    @BeforeClass
    public void setUp() {
        sliderPage = new SliderPage();
        sliderPage.goToSliderPage();
    }

    // Verifies the page header text
    @Test(priority = 1)
    public void verifyHeaderText() {
        Assert.assertEquals(sliderPage.getCurrentPageHeaderText(), "Slider", "Header text does not match!");
    }

    // Test that slider value doesn't exceed maximum (should clamp to 100)
    @Test(priority = 2)
    public void moveSliderBy101() {
        sliderPage.moveSlider(101);
        Assert.assertEquals(sliderPage.getSliderValue(), 100);
    }

    // Test setting slider to a normal mid-range value
    @Test(priority = 3)
    public void moveSliderBy50() {
        sliderPage.moveSlider(50);
        Assert.assertEquals(sliderPage.getSliderValue(), 50);
    }

    // Test that slider value doesn't go below minimum (should clamp to 0)
    @Test(priority = 4)
    public void moveSliderByNegative1() {
        sliderPage.moveSlider(-1);
        Assert.assertEquals(sliderPage.getSliderValue(), 0);
    }
}