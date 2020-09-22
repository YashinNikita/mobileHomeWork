package scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "search page and make a search using keyword ‘EPAM’")
    public void searchEpamInGoogle() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get("https://www.google.com/");
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("EPAM");
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        assertNotNull(getDriver().findElement(By.xpath("//cite[text() = \"www.epam.com\"]")));
    }

}
