import org.junit.Before;
import org.junit.Test;



public class AccountRegisterTest extends Hooks {

    public AccountRegisterPage registerPage;
    public CheckoutPage checkoutPage;


    @Before
    public void setupPageObject() {
        registerPage = new AccountRegisterPage(driver);
        driver.manage().window().maximize();
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void register() throws InterruptedException {

        registerPage.getAccount();
        registerPage.getRegister();
        registerPage.clickFirstNameField();
        registerPage.setFirstName();
        registerPage.setMiddleName();
        registerPage.setLastName();
        registerPage.setEmailAdd();
        registerPage.setPasswordAdd();
        registerPage.setPasswordConfirmation();
        registerPage.getRegisterButton();
        checkoutPage.assertTextWhenReady(registerPage.registerSuccess, "Thank you for registering with Madison Island.");
        System.out.println("Can you register?");

    }

    @Test
    public void registerMandatoryFirstName() throws InterruptedException { // test negativ
        registerPage.fillMandatoryFieldsExcept(registerPage.firstNameField);
        registerPage.assertTextWhenReady(registerPage.mandatoryFirstNameRegister, "This is a required field.");
        System.out.println("Yes1!");
    }

    @Test
    public void registerMandatoryLastName() throws InterruptedException { // test negativ
        registerPage.fillMandatoryFieldsExcept(registerPage.lastNameField);
        registerPage.assertTextWhenReady(registerPage.mandatoryLastNameRegister, "This is a required field.");
        System.out.println("Yes2!");
    }

    @Test
    public void registerMandatoryEmail() throws InterruptedException { // test negativ
        registerPage.fillMandatoryFieldsExcept(registerPage.emailAdd);
        registerPage.assertTextWhenReady(registerPage.mandatoryEmailRegister, "This is a required field.");
        System.out.println("Yes3!");
    }

    @Test
    public void registerMandatoryPassword() throws InterruptedException { // test negativ
        registerPage.fillMandatoryFieldsExcept(registerPage.passwordAdd);
        registerPage.assertTextWhenReady(registerPage.mandatoryPassword, "This is a required field.");
        System.out.println("Yes4!");
    }

    @Test
    public void registerMandatoryConfirmPassword() throws InterruptedException { // test negativ
        registerPage.fillMandatoryFieldsExcept(registerPage.passwordConfirmation);
        registerPage.assertTextWhenReady(registerPage.mandatoryConfirmPassword, "This is a required field.");
        System.out.println("Yes5!");
    }




}
