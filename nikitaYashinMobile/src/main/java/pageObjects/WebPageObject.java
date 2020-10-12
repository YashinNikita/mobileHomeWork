package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {
    private GoogleHomePageObject googleHomePageObject;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        googleHomePageObject = new GoogleHomePageObject(appiumDriver);
    }
}
