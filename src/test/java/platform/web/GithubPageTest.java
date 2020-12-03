package platform.web;

import common.BaseWebTest;
import org.junit.Test;
import platform.web.pages.GithubPage;

public class GithubPageTest extends BaseWebTest {

    private GithubPage githubPage;

    //Number 2 Create a Gist
    @Test()
    public void Github_01() {
        getWebDriver().get("https://www.github.com");
        githubPage = new GithubPage(getWebDriver());
        githubPage.checkElementInWebIsDisplayed();
        githubPage.clickSignInButton();
        githubPage.inputUsernameOrEmail("");
        githubPage.inputPassword("");
        githubPage.clickSignInButtonLoginPage();
        githubPage.clickSummaryCreateNew();
        githubPage.clickNewGist();
        githubPage.inputGistDesc("Lorem Ipsum");
        githubPage.inputGistFilename("Lorem Ipsum");
        githubPage.inputGistContent("Lorem Ipsum");
        githubPage.clickCreateSecretGist();
    }

    //Number 2 Edit a Gist
    @Test()
    public void Github_02() {
        getWebDriver().get("https://www.github.com");
        githubPage = new GithubPage(getWebDriver());
        githubPage.checkElementInWebIsDisplayed();
        githubPage.clickSignInButton();
        githubPage.inputUsernameOrEmail("");
        githubPage.inputPassword("");
        githubPage.clickSignInButtonLoginPage();
        githubPage.clickSummaryViewMore();
        githubPage.clickYourGist();
        githubPage.clickExistingGist();
        githubPage.clickEditGist();
        githubPage.inputGistContent("Lorem Ipsum");
        githubPage.clickUpdateGist();
    }

    //Number 2 See Your List Gist
    @Test()
    public void Github_03() {
        getWebDriver().get("https://www.github.com");
        githubPage = new GithubPage(getWebDriver());
        githubPage.checkElementInWebIsDisplayed();
        githubPage.clickSignInButton();
        githubPage.inputUsernameOrEmail("");
        githubPage.inputPassword("");
        githubPage.clickSignInButtonLoginPage();
        githubPage.clickSummaryViewMore();
        githubPage.clickYourGist();
    }

    //Number 2 Delete Your List Gist
    @Test()
    public void Github_04() {
        getWebDriver().get("https://www.github.com");
        githubPage = new GithubPage(getWebDriver());
        githubPage.checkElementInWebIsDisplayed();
        githubPage.clickSignInButton();
        githubPage.inputUsernameOrEmail("");
        githubPage.inputPassword("");
        githubPage.clickSignInButtonLoginPage();
        githubPage.clickSummaryViewMore();
        githubPage.clickYourGist();
        githubPage.clickExistingGist();
        githubPage.clickDeleteGist();
        githubPage.clickAcceptAlert();
        githubPage.sleepThread(1000);
    }
}
