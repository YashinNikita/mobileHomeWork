package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.IDriver;

import java.util.List;
@NoArgsConstructor
public class GoogleHomePageObject {

    public String url = "https://www.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    WebElement queryField;
    @FindBy(id = "result-stats")
    List<WebElement> resultStatuses;

    public GoogleHomePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        appiumDriver.get(url);
    }


}
