package pageObjects;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@NoArgsConstructor
public class GoogleHomePageObject {

    private String url = "https://www.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement queryField;
    @FindBy(xpath = "//div[@id='rso']//following-sibling::*")
    private List<WebElement> resultStatuses;

    public GoogleHomePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        appiumDriver.get(url);
    }


}