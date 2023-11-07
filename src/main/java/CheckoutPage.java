import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class CheckoutPage extends BasePage {
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 5);

    }

    @FindBy(xpath = "//a[text()='Food']") // (css = ".nav-16 > .level0")
    private WebElement foodMenu;

    public void getFoodMenu() {
        foodMenu.click();
    }

    @FindBy(css = ".product-info button")  // .btn-cart:nth-child(1) > span > span"
    public WebElement addToCart;

    public void getAddToCart() {
        addToCart.click();
    }

    public String test = "Salut!";

    @FindBy(id = "city")
    private WebElement cityCart;

    public void getCityCart() {
        cityCart.sendKeys("alabama city");
    }

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    @FindBy(id = "onepage-guest-register-button")
    private WebElement registerButton;

    public void clickRegisterButton() {
        registerButton.click();
    }

    @FindBy(id = "billing:firstname")
    public WebElement firstNameField;

    public void clickFirstNameField() {
        firstNameField.click();
    }

    public void setFirstName(String name) {
        firstNameField.sendKeys(name);
    }

    @FindBy(id = "billing:middlename")
    private WebElement middleNameField;

    public void setMiddleName(String name) {
        middleNameField.sendKeys(name);
    }

    @FindBy(id = "billing:lastname")
    public WebElement lastNameField;

    @FindBy(id = "billing:address")
    public WebElement addressField;

    @FindBy(id = "billing:city")
    public WebElement cityAddress;

    @FindBy(id = "billing:postcode")
    public WebElement zipPostalCode;

    @FindBy(id = "billing:telephone")
    public WebElement telephone;


    public void setLastName(String name) {
        lastNameField.sendKeys(name);
    }

    @FindBy(id = "billing:company")
    private WebElement companyField;

    public void setCompany(String company) {
        companyField.sendKeys(company);
    }

    @FindBy(id = "billing:telephone")
    private WebElement billingTelephone;

    public void setBillingTelephone(String number) {
        billingTelephone.sendKeys(number);
    }

    @FindBy(id = "billing:email")
    private WebElement emailField;

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }


    @FindBy(id = "billing:street1")
    public WebElement street1Field;

    public void setStreet1(String address) {
        street1Field.sendKeys(address);
    }

    @FindBy(id = "billing:street2")
    private WebElement street2Field;

    public void setStreet2(String address) {
        street2Field.sendKeys(address);
    }

    @FindBy(id = "billing:postcode")
    public WebElement billingPostcode;

    public void setBillingPostcode(String postcode) {
        billingPostcode.sendKeys(postcode);
    }

    @FindBy(id = "billing:city")
    private WebElement cityField;

    public void setCity(String city) {
        cityField.sendKeys(city);
    }

    @FindBy(id = "billing:region_id")
    private WebElement regionDropdown;

    public void clickRegionDropdown() {
        regionDropdown.click();
    }

    public void selectRegion(String regionName) {
        Select regionSelect = new Select(regionDropdown);
        regionSelect.selectByVisibleText(regionName);
    }

    @FindBy(id = "region_id")
    private WebElement cartRegionDropdown;

    public void clickCartRegionDropdown() {
        cartRegionDropdown.click();
    }

    public void selectCartRegion(String cartRegionName) {
        Select cartRegionSelect = new Select(cartRegionDropdown);
        cartRegionSelect.selectByVisibleText(cartRegionName);
    }

    @FindBy(id = "postcode")
    private WebElement postcodeField;

    public void setPostcode(String postcode) {
        postcodeField.sendKeys(postcode);
    }

    @FindBy(css = "#billing-buttons-container button")
    public WebElement billingContinue;

    @FindBy(css = "#shipping-method-buttons-container button")
    public WebElement shippingContinue;

    @FindBy(css = "#payment-buttons-container button")
    public WebElement lastContinue;

    @FindBy(css = ".btn-checkout")
    public WebElement order;

    @FindBy(xpath = "//div[@class='page-title']")
    public WebElement pageTitle;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement mandatoryFirstName;

    @FindBy(id = "advice-required-entry-billing:lastname")
    public WebElement mandatoryLastName;

    @FindBy(id = "advice-required-entry-billing:street1")
    public WebElement mandatoryAddress;

    @FindBy(id = "advice-required-entry-billing:city")
    public WebElement mandatoryCity;

    @FindBy(id = "advice-required-entry-billing:postcode")
    public WebElement mandatoryZip;

    @FindBy(id = "advice-required-entry-billing:telephone")
    public WebElement mandatoryTelephone;


    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e){
            System.out.println("Text not present");
        }
        assertEquals(expectedText, locator.getText());
    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip) throws InterruptedException {
        getFoodMenu();
        getAddToCart();
        completeAndSubmitCart();
        completeAllMandatoryFieldsInCheckoutPage();
        fieldToSkip.clear();
        clickWhenReady(billingContinue);

    }

    public void completeAndSubmitCart() {
        getCityCart();
        setPostcode("12345");
        clickCartRegionDropdown();
        selectCartRegion("Alabama");
        clickCheckoutButton();
        clickRegisterButton();
    }

    public void completeAllMandatoryFieldsInCheckoutPage() {
        setFirstName("Test");
        setMiddleName("Test2");
        setLastName("Test3");
        setCompany("Test5");
        setEmail("asdf@example.com");
        setStreet1("adresa mea");
        setStreet2("adresa mea 2");
        setCity("Alabama City");
        selectRegion("Alabama");
        setBillingPostcode("12345");
        setBillingTelephone("0777777777");
    }

    public void clickAllContinueButtonsOnCheckoutPage() {
        clickWhenReady(billingContinue);
        clickWhenReady(shippingContinue);
        clickWhenReady(lastContinue);
        clickWhenReady(order);


    }


}




