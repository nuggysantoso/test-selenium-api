package platform.web.modules;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    protected abstract void checkElementInWebIsDisplayed();

    protected void assertTrue(String message, boolean condition){
        Assert.assertTrue(message, condition);
    }

    protected void assertEquals(String message, String expected, String actual){
        Assert.assertEquals(message, expected, actual);
    }

    protected void assertTextElementIsEquals(WebElement webElement, String expected){
        String actual = getTextOrValueElement(webElement);
        assertEquals("Failed : "+ actual + " Not Equals With "+ expected, expected, actual);
    }

    protected void assertElementIsDisplayed(WebElement webElement){
        waitForVisibilityOf(webElement);
        assertTrue("Failed : "+ webElement.toString() + " Is Not Displayed", isElementPresent(webElement));
    }

    protected Select selectDropdown(WebElement webElement){
        assertElementIsDisplayed(webElement);
        Select select = new Select(webElement);
        return select;
    }

    protected void clickElement(WebElement webElement){
        assertElementIsDisplayed(webElement);
        webElement.click();
    }

    protected void inputTextToElement(WebElement webElement, String textToInput){
        assertElementIsDisplayed(webElement);
        webElement.sendKeys(textToInput);
    }

    protected String getTextOrValueElement(WebElement webElement){
        assertElementIsDisplayed(webElement);
        return webElement.getText();
    }

    protected Boolean isElementPresent(WebElement webElement){
       return webElement.isDisplayed();
    }

    protected void waitForVisibilityOf(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForVisibilityOf(WebElement webElement, int timeOut) {
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
}
