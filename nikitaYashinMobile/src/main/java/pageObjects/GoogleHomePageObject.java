package pageObjects;

import io.appium.java_client.AppiumDriver;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@NoArgsConstructor
public class GoogleHomePageObject {

    public String url = "https://www.google.com/";
    AppiumDriver page;

    @FindBy(xpath = "//input[@name='q']")
    WebElement queryField;
    @FindBy(xpath = "//div[@id='rso']//following-sibling::*")
    List<WebElement> resultStatuses;

    public GoogleHomePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        page = appiumDriver;
    }

    public void open() {
        page.get(url);
    }

    public void querySome(String query) {
        queryField.sendKeys(query, Keys.ENTER);
    }

    public boolean checkIfQueryFindSomething() {
        return resultStatuses.size() > 1;
    }


}
