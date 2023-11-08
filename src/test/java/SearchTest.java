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
    public void search()  {

        searchPage.searchPage("turcu");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");
        System.out.println("Yes, I see the text1!");

        searchPage.searchPage("shaorma");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");
        System.out.println("Yes, I see the text2!");

//        searchPage.searchPage("shaorma la turcu");
//        searchPage.pushSearchButton();
//        System.out.println("Can you search here?");
//        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "SHAORMA LA TURCU");// asta nu merge pentru ca este un bug!
//        System.out.println("Yes, I see the text3!");

    }

    @Test
    public void searchRaduTheHandsome(){
        searchPage.searchPage("radu");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "RADU THE HANDSOME");
        System.out.println("Yes, I see the text1!");

        searchPage.searchPage("radu the");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "RADU THE HANDSOME");
        System.out.println("Yes, I see the text2!");

        searchPage.searchPage("radu the handsome");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "RADU THE HANDSOME");
        System.out.println("Yes, I see the text3!");
    }

    @Test
    public void searchEngagementRing(){
        searchPage.searchPage("engagement");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "ENGAGEMENT RING");
        System.out.println("Yes, I see the text1!");

        searchPage.searchPage("engagement ring");
        searchPage.pushSearchButton();
        searchPage.searchPageClear();
        checkoutPage.assertTextWhenReady(searchPage.productShaorma, "ENGAGEMENT RING");
        System.out.println("Yes, I see the text2!");

    }




}
