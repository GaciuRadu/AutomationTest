import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class SearchPage extends BasePage {
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 5);

    }

    @FindBy(id = "search")
    private WebElement searchField;

    public void searchPage(String text) {
        searchField.sendKeys(text);

    }
    public void searchPageClear() {
        searchField.clear();

    }

    @FindBy(css = ".product-name ")
    public WebElement productShaorma;

    @FindBy(css = ".search-button")
    private WebElement buttonSearch;

    public void pushSearchButton() {
        buttonSearch.click();

    }


    public void completeSearch() {
        searchPage("");
        pushSearchButton();
        searchPageClear();

    }
}






