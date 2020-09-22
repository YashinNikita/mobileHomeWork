package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.GoogleHomePageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    GoogleHomePageObject googleHomePageObject = new GoogleHomePageObject();

    //describes url, query field(xPath), query, query result(xPath)
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"https://www.google.com/", "//input[@name='q']", "EPAM", "//cite[text() = \"www.epam.com\"]"}
        };
    }

    @Test(dataProvider = "data-provider", groups = {"web"}, description = "search page and make a search using keyword ‘EPAM’")
    public void searchEpamInGoogle(String site, String inputField, String query, String result) {
        getDriver().get(site);
        getDriver().findElement(By.xpath(inputField)).sendKeys(query, Keys.ENTER);
        getDriver().findElement(By.xpath(result)).isDisplayed();
    }

}
