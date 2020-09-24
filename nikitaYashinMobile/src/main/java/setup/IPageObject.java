package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {
    WebElement getWelement(String weName)  throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    WebElement getBaseNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    WebElement getBudgetActivityNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    WebElement getRegistrationNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    WebElement getGoogleHomePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;



}
