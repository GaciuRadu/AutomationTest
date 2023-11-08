import org.junit.Before;
import org.junit.Test;


public class SearchTest extends Hooks {

    public SearchPage searchPage;
    public CheckoutPage checkoutPage;

    @Before
    public void setupPageObject() {
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void search() throws InterruptedException {

        searchPage.searchPage("turcu");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();

        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");
        searchPage.searchPage("shaorma");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();

        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");
//        searchPage.searchPage("shaorma la turcu");
//        searchPage.pushSearchButton();
//        System.out.println("Can you search here?");
//        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");// asta nu merge pentru ca este un bug!

    }


}
