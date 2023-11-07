import org.junit.Before;
import org.junit.Test;


public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;


    @Before
    public void setupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void checkout() throws InterruptedException {
        checkoutPage.getFoodMenu();
        checkoutPage.getAddToCart();
        checkoutPage.completeAndSubmitCart();
        checkoutPage.assertTextWhenReady(checkoutPage.pageTitle, "CHECKOUT");
        checkoutPage.completeAllMandatoryFieldsInCheckoutPage();
        checkoutPage.clickAllContinueButtonsOnCheckoutPage();
        checkoutPage.assertTextWhenReady(checkoutPage.pageTitle, "YOUR ORDER HAS BEEN RECEIVED.");
        System.out.println("Yes!");
    }

    @Test
    public void checkoutMandatoryFirstNameTest() throws InterruptedException { // test negativ
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.firstNameField);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryFirstName, "This is a required field.");
        System.out.println("Yes!");

    }

    @Test
    public void checkoutMandatoryLastNameTest() throws InterruptedException {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.lastNameField);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryLastName, "This is a required field.");
        System.out.println("Yes!");

    }
    @Test
    public void checkoutMandatoryAddressNameTest() throws InterruptedException {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.street1Field);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryAddress, "This is a required field.");
        System.out.println("Yes!");

    }
    @Test
    public void checkoutMandatoryCityNameTest() throws InterruptedException {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.cityAddress);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryCity, "This is a required field.");
        System.out.println("Yes!");

    }

    @Test
    public void checkoutMandatoryZipTest() throws InterruptedException {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.zipPostalCode);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryZip, "This is a required field.");
        System.out.println("Yes!");

    }

    @Test
    public void checkoutMandatoryTelephone() throws InterruptedException {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.telephone);
        checkoutPage.assertTextWhenReady(checkoutPage.mandatoryTelephone, "This is a required field.");
        System.out.println("Yes!");

    }


}
