package platform.web;

import common.BaseWebTest;
import org.junit.Test;
import platform.web.pages.EbayPage;

public class EbayPageTest extends BaseWebTest {

    private EbayPage ebayPage;
    //Number 1 Scenario 2
    @Test()
    public void Ebay_01() {
        getWebDriver().get("https://www.ebay.com");
        ebayPage = new EbayPage(getWebDriver());
        ebayPage.checkElementInWebIsDisplayed();
        ebayPage.searchInSearchTextBox("Macbook");
        ebayPage.clickAllCategoriesDropdown("Computers/Tablets & Networking");
        ebayPage.clickSearchButton();
        ebayPage.checkResultMatchSearchText("Macbook");
    }
}
