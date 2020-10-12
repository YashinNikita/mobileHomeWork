package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    private Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    private NativePageObject nativePageObject;
    private BudgetActivityNativePageObject budgetActivityNativePageObject;
    private RegistrationNativePageObject registrationNativePageObject;
    private GoogleHomePageObject googleHomePageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                googleHomePageObject = new GoogleHomePageObject(appiumDriver);
                break;
            case "native":
                nativePageObject = new NativePageObject(appiumDriver);
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
        Field field = nativePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(nativePageObject);
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
    public GoogleHomePageObject getGoogleHomePageObject(String weName)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        // use reflection technique
        Field field = googleHomePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (GoogleHomePageObject) field.get(googleHomePageObject);
    }
}
