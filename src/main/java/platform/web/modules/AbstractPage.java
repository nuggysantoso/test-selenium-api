package platform.web.modules;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Slf4j
public abstract class AbstractPage {

    /**
     * The wait.
     */
    protected Wait<WebDriver> wait;

    protected WebDriver webDriver;
    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 20);
        PageFactory.initElements(webDriver, this);
    }
    protected abstract void checkElementInWebIsDisplayed();

    protected void assertTrue(String message, boolean condition){
        Assert.assertTrue(message, condition);
    }

    protected void assertEquals(String message, String expected, String actual){
        Assert.assertEquals(message, expected, actual);
    }

    protected void assertTextElementIsEquals(String locator, String expected){
        String actual = getTextOrValueElement(locator);
        assertEquals("Failed : "+ actual + " Not Equals With "+ expected, expected, actual);
    }

    protected void assertElementIsDisplayed(String locator){
        log.info("Check Element With Locator : " + locator);
        assertTrue("Failed : "+ locator + " Is Not Displayed", isElementPresent(locator));
        log.info("Check Element With Locator : " + locator + " Is Displayed");
    }

//    protected Select selectDropdown(WebElement webElement){
//        assertElementIsDisplayed(webElement);
//        Select select = new Select(webElement);
//        return select;
//    }

    protected void clickElement(String locator){
        log.info("Click Element With Locator : " + locator);
        assertElementIsDisplayed(locator);
        waitForVisibilityOfElementByXpath(locator).click();
        log.info("Click Element With Locator : " + locator + " Successfully");
    }

    protected void inputTextToElement(String locator, String textToInput){
        log.info("Input Text To Element : " + locator + " With Text : " + textToInput);
        assertElementIsDisplayed(locator);
        waitForVisibilityOfElementByXpath(locator).sendKeys(textToInput);
        log.info("Input Text To Element : " + locator + " With Text : " + textToInput + " Successfully");
    }

    protected String getTextOrValueElement(String locator){
        assertElementIsDisplayed(locator);
        return waitForVisibilityOfElementByXpath(locator).getText();
    }

    protected Boolean isElementPresent(String locator){
       return waitForVisibilityOfElementByXpath(locator).isDisplayed();
    }

    protected WebElement waitForVisibilityOfElementByXpath(String locator) {
        By xpath = By.xpath(locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    protected WebElement waitForVisibilityOfElementByTagName(String locator) {
        By xpath = By.tagName(locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    protected void waitForVisibilityOfElementByXpath(WebElement webElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForClickabilityOf(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void WaitForClickabilityOf(WebElement webElement, int time){
        WebDriverWait wait = new WebDriverWait(webDriver, time);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement getElementById(String id){
        return webDriver.findElement(By.id(id));
    }

    protected WebElement getElementByCssSelector(String cssSelector){
        return webDriver.findElement(By.cssSelector(cssSelector));
    }

    protected WebElement getElementByXPath(String xPath){
        return webDriver.findElement(By.xpath(xPath));
    }

    protected WebElement getElementByClassName(String className){
        return webDriver.findElement(By.className(className));
    }

    protected WebElement getElementByName(String name){
        return webDriver.findElement(By.name(name));
    }

    protected WebElement getElementByTagName(String tagName){
        return webDriver.findElement(By.tagName(tagName));
    }

    protected List<WebElement> getElementsByTagName(String tagName){
        return webDriver.findElements(By.tagName(tagName));
    }

    protected WebElement getElementByLinkText(String linkText){
        return webDriver.findElement(By.linkText(linkText));
    }

    protected WebElement getElementByPartialLinkText(String partialLinkText){
        return webDriver.findElement(By.partialLinkText(partialLinkText));
    }

    public void sleepThread(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickAcceptAlert(){
        webDriver.switchTo().alert().accept();
    }

    public void switchToFrameOrToParent(boolean defaultContent, int... index){
        if (index.length > 0) {
            webDriver.switchTo().frame(index[0]);
        }
        if (defaultContent) {
            webDriver.switchTo().defaultContent();
        }
    }
}
