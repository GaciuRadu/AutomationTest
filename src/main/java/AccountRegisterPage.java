import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;


public class AccountRegisterPage extends BasePage {
    private WebDriverWait wait;

    public AccountRegisterPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 5);

    }

    @FindBy(css = ".account-cart-wrapper")
    public WebElement account;

    public void getAccount() {
        account.click();
    }

    @FindBy(css = ".links:nth-child(1) li:nth-child(5) > a")
    private WebElement register;

    public void getRegister() {
        register.click();
    }


    @FindBy(id = "firstname")
    public WebElement firstNameField;

    public void clickFirstNameField() {
        firstNameField.click();
    }

    public void setFirstName() {
        firstNameField.sendKeys("Radu");
    }


    @FindBy(id = "middlename")
    private WebElement middleNameField;

    public void setMiddleName() {
        middleNameField.sendKeys("Cristian");
    }

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    public void setLastName() {
        lastNameField.sendKeys("Gaciu");
    }


    public void clickLastNameField() {
        lastNameField.click();
    }

    @FindBy(id = "email_address")
    public WebElement emailAdd;


    public void setEmailAdd() {
        String random = RandomStringUtils.randomAlphanumeric(10);
        emailAdd.sendKeys(random + "@yahoo.com");
    }
    public void clickEmailField() {
        emailAdd.click();
    }


    @FindBy(id = "password")
    public WebElement passwordAdd;

    public void setPasswordAdd() {

        passwordAdd.sendKeys("GRC1975");
    }

    public void clickPasswordField() {
        passwordAdd.click();
    }



    @FindBy(id = "confirmation")
    public WebElement passwordConfirmation;

    public void setPasswordConfirmation() {
        passwordConfirmation.sendKeys("GRC1975");
    }

    public void clickConfirmPasswordField() {
        passwordConfirmation.click();
    }

    @FindBy(css = ".buttons-set button")
    public WebElement registerButton;

    public void getRegisterButton() {
        registerButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();

    }

    @FindBy(css = ".product-name")
    public WebElement myDashboard;

    @FindBy(css = ".success-msg")
    public WebElement registerSuccess;


    public void completeRegistration() {
        getAccount();
        getRegister();
        clickFirstNameField();
        clickLastNameField();
        clickEmailField();
        clickPasswordField();
        clickConfirmPasswordField();


    }



    @FindBy(id = "advice-required-entry-firstname")
    public WebElement mandatoryFirstNameRegister;

    @FindBy(id = "advice-required-entry-lastname")
    public WebElement mandatoryLastNameRegister;

    @FindBy(id = "advice-required-entry-email_address")
    public WebElement mandatoryEmailRegister;

    @FindBy(id = "advice-required-entry-password")
    public WebElement mandatoryPassword;

    @FindBy(id = "advice-required-entry-confirmation")
    public WebElement mandatoryConfirmPassword;


    public void assertTextWhenReady(WebElement locator, String expectedText) {
        WebElement until = wait.until(ExpectedConditions.visibilityOf(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        assertEquals(expectedText, locator.getText());
    }

    public void fillMandatoryFieldsExcept(WebElement fielfToSkip) throws InterruptedException {
        getAccount();
        getRegister();
        clickFirstNameField();
        clickLastNameField();
        clickEmailField();
        clickPasswordField();
        clickConfirmPasswordField();
        clickRegisterButton();



    }

}






