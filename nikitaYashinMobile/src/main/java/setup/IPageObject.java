package setup;

import org.openqa.selenium.WebElement;
import pageObjects.GoogleHomePageObject;

public interface IPageObject {
    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getBaseNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getBudgetActivityNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getRegistrationNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    GoogleHomePageObject getGoogleHomePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
