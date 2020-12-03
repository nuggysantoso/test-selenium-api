package platform.web.pages;

import org.openqa.selenium.WebDriver;
import platform.web.modules.AbstractPage;

public class GithubPage extends AbstractPage{
    private String titlePage = "user[login]";
    private String signInButton = "//a[@href='/login']";
    private String emailOrUsernameTxtBox = "login_field";
    private String passwordTxtBox = "password";
    private String signInBtn = "//input[@value='Sign in']";
    private String summaryCreateNew = "//summary[@aria-label='Create new…']";
    private String summaryViewMore = "//summary[@aria-label='View profile and more']";
    private String newGist = "//a[@data-ga-click='Header, create new gist']";
    private String yourGist = "//a[@data-ga-click='Header, your gists, text:your gists']";
    private String gistDesc = "//input[@placeholder='Gist description…']";
    private String gistFilename = "//input[@placeholder='Filename including extension…']";
    private String gistContent = "//span[@role='presentation']";
    private String existingGist = "//strong[text()='Lorem Ipsum']";
    private String createSecretGistBtn = "//button[text()='Create secret gist']";
    private String editGist = "//a[@aria-label='Edit this Gist']";
    private String updateSecretGist = "//button[contains(text(), 'Update secret gist')]";
    private String deleteGist = "//button[@aria-label='Delete this Gist']";

    public GithubPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void checkElementInWebIsDisplayed() {
        assertElementIsDisplayed(getElementById(titlePage));
    }

    public void clickSignInButton(){
        clickElement(getElementByXPath(signInButton));
    }

    public void inputUsernameOrEmail(String text){
        inputTextToElement(getElementById(emailOrUsernameTxtBox), text);
    }

    public void inputPassword(String text){
        inputTextToElement(getElementById(passwordTxtBox), text);
    }

    public void clickSignInButtonLoginPage(){
        clickElement(getElementByXPath(signInBtn));
    }

    public void clickSummaryCreateNew(){
        clickElement(getElementByXPath(summaryCreateNew));
    }

    public void clickSummaryViewMore(){
        clickElement(getElementByXPath(summaryViewMore));
    }

    public void clickYourGist(){
        clickElement(getElementByXPath(yourGist));
    }

    public void clickNewGist(){
        clickElement(getElementByXPath(newGist));
    }

    public void inputGistDesc(String text){
        inputTextToElement(getElementByXPath(gistDesc), text);
    }

    public void inputGistFilename(String text){
        inputTextToElement(getElementByXPath(gistFilename), text);
    }

    public void inputGistContent(String text){
        inputTextToElement(getElementByXPath(gistContent), text);
    }

    public void clickCreateSecretGist(){
        clickElement(getElementByXPath(createSecretGistBtn));
    }

    public void clickExistingGist(){
        sleepThread(3000);
        clickElement(getElementByXPath(existingGist));
    }

    public void clickEditGist(){
        clickElement(getElementByXPath(editGist));
    }

    public void clickUpdateGist(){
        clickElement(getElementByXPath(updateSecretGist));
    }

    public void clickDeleteGist(){
        clickElement(getElementByXPath(deleteGist));
    }
}
