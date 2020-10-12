package scenarios;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.GoogleHomePageObject;
import setup.BaseTest;

import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {
    private GoogleHomePageObject googleHomePageObject;
    private String company = properties.getProperty("company");

    @Test(groups = {"web"}, description = "method searsh a search using keyword ‘EPAM’")
    public void test2() {
        googleHomePageObject = new GoogleHomePageObject(getDriver());
        getDriver().get(googleHomePageObject.getUrl());
        googleHomePageObject.getQueryField().sendKeys(company, Keys.ENTER);
        assertTrue(googleHomePageObject.getResultStatuses().size() > 2);
    }

}
