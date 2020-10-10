package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    private Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    private BaseNativePageObject baseNativePageObject;
    private BudgetActivityNativePageObject budgetActivityNativePageObject;
    private RegistrationNativePageObject registrationNativePageObject;
    private GoogleHomePageObject googleHomePageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "web":
                somePageObject = new GoogleHomePageObject(appiumDriver);
                break;
            case "native":
                baseNativePageObject = new BaseNativePageObject(appiumDriver);
                budgetActivityNativePageObject = new BudgetActivityNativePageObject(appiumDriver);
                registrationNativePageObject = new RegistrationNativePageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create a page object for " + appType);
        }

    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);
    }

    @Override
    public WebElement getBaseNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = baseNativePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(baseNativePageObject);
    }

    @Override
    public WebElement getBudgetActivityNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = budgetActivityNativePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(budgetActivityNativePageObject);
    }

    @Override
    public WebElement getRegistrationNativePageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = registrationNativePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(registrationNativePageObject);
    }

    @Override
    public WebElement getGoogleHomePageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // use reflection technique
        Field field = googleHomePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(googleHomePageObject);
    }

}
