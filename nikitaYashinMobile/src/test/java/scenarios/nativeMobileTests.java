package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {

    @Test(priority = 2, groups = {"native"}, description = "register a new account and then sign in")
    public void singIn() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerBtn").click();
        getPo().getWelement("registrationEmailField").sendKeys("nik@mail.ru");
        getPo().getWelement("registrationUserNameField").sendKeys("nik");
        getPo().getWelement("registrationPasswordField").sendKeys("qwerty123");
        getPo().getWelement("registrationConfirmPasswordField").sendKeys("qwerty123");
        getPo().getWelement("registrationNewAccountBtn").click();
        System.out.println("new user email - nik@mail.ru password - qwerty123 registered ");

        getPo().getWelement("emailOrUserNameField").sendKeys("nik@mail.ru");
        getPo().getWelement("passwordField").sendKeys("qwerty123");
        getPo().getWelement("signInBtn").click();
        System.out.println("new user email - nik@mail.ru password - qwerty123 logged in ");

        assertTrue(getPo().getWelement("budgetActivity").isDisplayed());
        System.out.println("SingUp scenario done");
    }

}
