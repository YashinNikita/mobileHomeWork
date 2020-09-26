package demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;


public class AppiumDemoIos {

    private static final String PROJECT_NAME = "EPM-TSTF";

    private static final String API_KEY = "be4696f6-bb71-4b8b-9ccb-11b9b0025cfe";
    private static final String APPIUM_HUB = "mobilecloud.epam.com";
    private static final String PLATFORM_NAME = "iOS";
    private static final String PLATFORM_VERSION = "13.3.1";
    private static final String BROWSER_NAME = "safari";
    private static final String DEVICE_NAME = "IPAD 7,3";

    private final DesiredCapabilities capabilities;

    private AppiumDriver driver = null;

    public AppiumDemoIos() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("browserName", BROWSER_NAME);
        capabilities.setCapability("deviceName", DEVICE_NAME);
    }

    @Before
    public void before() throws MalformedURLException {
        driver = new IOSDriver(
                new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);

        // For devices with low performance
        driver.manage().timeouts()
                .pageLoadTimeout(5, TimeUnit.MINUTES)
                .implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test
    public void demoTest() {
        final String epamUrl = "https://www.epam.com/";

        assertTrue(format("Focus is not on '%s'", BROWSER_NAME), driver.isBrowser());

        driver.get(epamUrl);

        new FluentWait<>(driver).withMessage("Page was not loaded")
                .pollingEvery(ofSeconds(1))
                .withTimeout(ofMinutes(1))
                .until(driver -> driver.findElements(className("header__logo")).size() > 0);

        assertEquals("Current url is incorrect", epamUrl, driver.getCurrentUrl());
        assertEquals("Page title is incorrect", "EPAM | Enterprise Software Development, Design & Consulting", driver.getTitle());
    }

    @After
    public void after() {
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
    }
}
