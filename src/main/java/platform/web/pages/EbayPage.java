package platform.web.pages;

import org.openqa.selenium.WebDriver;
import platform.web.modules.AbstractPage;

public class EbayPage extends AbstractPage {
    private String titlePage = "gh";
    private String categoriesDropdown = "gh-cat";
    private String searchButton = "gh-btn";
    private String searchTextBox = "gh-ac";
    private String moreRefinement = "//button/span[text()='More refinements']";

    public EbayPage(WebDriver webDriver) {
       super(webDriver);
    }

    @Override
    public void checkElementInWebIsDisplayed() {
        assertElementIsDisplayed(getElementById(titlePage));
    }

    public void clickAllCategoriesDropdown(String text){
        selectDropdown(getElementById(categoriesDropdown)).selectByVisibleText(text);
    }

    public void searchInSearchTextBox(String text){
        inputTextToElement(getElementById(searchTextBox), text);
    }

    public void clickSearchButton(){
        clickElement(getElementById(searchButton));
    }

    public void checkResultMatchSearchText(String text){
        assertElementIsDisplayed(getElementByXPath("//span[text()="+"'" + text + "']"));
    }
}
