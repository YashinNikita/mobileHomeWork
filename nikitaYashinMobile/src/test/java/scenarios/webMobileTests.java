package scenarios;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.GoogleHomePageObject;
import setup.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {
    private GoogleHomePageObject googleHomePageObject;

    @Test(groups = {"web"}, description = "method searsh a search using keyword ‘EPAM’")
    public void test2() throws IOException {
        googleHomePageObject = new GoogleHomePageObject(getDriver());
        getDriver().get(googleHomePageObject.getUrl());
        googleHomePageObject.getQueryField().sendKeys(getProperties().getProperty("company"), Keys.ENTER);
        assertTrue(googleHomePageObject.getResultStatuses().size() > 2);
    }

}