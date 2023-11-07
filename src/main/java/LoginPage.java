import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class LoginPage extends BasePage {
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 5);

    }

    @FindBy(css = ".account-cart-wrapper")
    public WebElement account;

    public void getAccount() {
        account.click();
    }

    @FindBy(linkText = "Log In")
   public WebElement skipAccount;

    public void getSkipAccount() {
        skipAccount.click();
    }


    @FindBy(id = "email")
    public WebElement emailAdd;

    public void setEmailAdd(String email) {
        emailAdd.sendKeys(email);
    }
    public void emailAddMandatory() {
        emailAdd.click();
    }



    ;


    @FindBy(id = "pass")
    public WebElement passwordAdd;

    public void setPasswordAdd(String newPassword) {
        passwordAdd.sendKeys(newPassword);
    }

    public void getPasswordMandatory() {
        passwordAdd.click();
    }


    @FindBy(id = "send2")
    public WebElement logInButton;

    public void setLogInButton() {
        logInButton.click();
    }

    @FindBy(id = "advice-required-entry-email")
    public WebElement mandatoryEmail;

    @FindBy(id = "advice-required-entry-pass")
    public WebElement mandatoryPassword;


    public void completeAllLogIn() {
        getAccount();
        getSkipAccount();
        setEmailAdd("asdf@example.com");
        setPasswordAdd("123abcABC");
        setLogInButton();
    }


    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        assertEquals(expectedText, locator.getText());
    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip) {
        getAccount();
        getSkipAccount();
        emailAddMandatory();
        setLogInButton();
        getPasswordMandatory();
        setLogInButton();
    }




}




