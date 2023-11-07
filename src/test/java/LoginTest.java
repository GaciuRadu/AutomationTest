import org.junit.Before;
import org.junit.Test;


public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public CheckoutPage checkoutPage;


    @Before
    public void setupPageObject() {
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        driver.manage().window().maximize();
    }


    @Test
    public void login() throws InterruptedException {
        loginPage.getAccount();
        loginPage.getSkipAccount();
        loginPage.setEmailAdd("radu@yahoo.com");
        loginPage.setPasswordAdd("GRC1975");
        loginPage.setLogInButton();
        loginPage.assertTextWhenReady(checkoutPage.pageTitle, "MY DASHBOARD");
        System.out.println("Hello Login Test");
    }

    @Test
    public void logInEmailMandatory() { // test negativ
        loginPage.fillMandatoryFieldsExcept(loginPage.emailAdd);
        checkoutPage.assertTextWhenReady(loginPage.mandatoryEmail, "This is a required field.");
        System.out.println("Yes1!");
    }
    @Test
    public void logInPasswordMandatory() { // test negativ
        loginPage.fillMandatoryFieldsExcept(loginPage.passwordAdd);
        checkoutPage.assertTextWhenReady(loginPage.mandatoryPassword, "This is a required field.");
        System.out.println("Yes2!");
    }
}
