package scenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {

    private String email = properties.getProperty("email");
    private String name = properties.getProperty("username");
    private String password = properties.getProperty("password");


    @Test(groups = {"native"}, description = "register and sign in as a new user")
    public void singUpAsNewUser()
            throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getBaseNativePageObject("registerBtn").click();
        getPo().getRegistrationNativePageObject("registrationEmailField").sendKeys(email);
        getPo().getRegistrationNativePageObject("registrationUserNameField").sendKeys(name);
        getPo().getRegistrationNativePageObject("registrationPasswordField").sendKeys(password);
        getPo().getRegistrationNativePageObject("registrationConfirmPasswordField").sendKeys(password);
        getPo().getRegistrationNativePageObject("registrationNewAccountBtn").click();
        getPo().getBaseNativePageObject("emailOrUserNameField").sendKeys(email);
        getPo().getBaseNativePageObject("passwordField").sendKeys(password);
        getPo().getBaseNativePageObject("signInBtn").click();

        assertTrue(getPo().getBudgetActivityNativePageObject("addExpBtn").isDisplayed());
    }

}
