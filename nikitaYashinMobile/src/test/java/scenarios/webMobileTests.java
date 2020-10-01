package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.GoogleHomePageObject;
import setup.BaseTest;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    GoogleHomePageObject googleHomePageObject;

    //to add more if needed
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"EPAM"}
        };
    }

    @Test(dataProvider = "data-provider", groups = {"web"}, description = "method searsh a search using keyword ‘EPAM’")
    public void test2(String search){
        googleHomePageObject = new GoogleHomePageObject(getDriver());

        getDriver().get(googleHomePageObject.url);
        googleHomePageObject.getQueryField().sendKeys(search, Keys.ENTER);
        assertTrue(googleHomePageObject.getResultStatuses().size() > 2);
    }

}
