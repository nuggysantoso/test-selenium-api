package platform.web.pages;

import org.openqa.selenium.WebDriver;
import platform.web.modules.AbstractPage;

public class MidtransPage extends AbstractPage {
    private String buyButton = "//a[text()='BUY NOW']";
    private String shoppingCart = "//span[contains(text(), 'Shopping Cart')]";
    private String checkoutBtn = "//div[contains(text(), 'CHECKOUT')]";
    private String continueBtn = "//a[@href='#/select-payment']";
    private String creditOrDebitCard = "//div[text()='Credit/Debit Card']";
    private String cardNumberInput = "//input[@name='cardnumber']";
    private String expiryDateInput = "//input[@placeholder='MM / YY']";
    private String cvvNumberInput = "//input[@placeholder='123']";
    private String payNowBtn = "//a[@class='button-main-content']";
    private String otpField = "//input[@id='PaRes']";
    private String okBtn = "//button[@name='ok']";

    public MidtransPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void checkElementInWebIsDisplayed() {
        assertElementIsDisplayed(buyButton);
    }

    public void clickBuyButton(){
        clickElement(buyButton);
    }

    public void checkShoppingCartSpanIsDisplayed(){
        assertElementIsDisplayed(shoppingCart);
    }

    public void clickCheckoutButton(){
        clickElement(checkoutBtn);
    }

    public void clickContinueButton(){
        switchToFrameOrToParent(false, getElementsByTagName("iframe").size()-1);
        clickElement(continueBtn);
    }

    public void clickCreditOrDebitCard(){
        clickElement(creditOrDebitCard);
    }

    public void inputCardNumber(String cardNumber){
        inputTextToElement(cardNumberInput, cardNumber);
    }

    public void inputExpiryDate(String expiryDate){
        inputTextToElement(expiryDateInput, expiryDate);
    }

    public void inputCvvNumber(String cvvNumber){
        inputTextToElement(cvvNumberInput, cvvNumber);
    }

    public void assertPayNowStillAppear(){
        assertElementIsDisplayed(payNowBtn);
    }

    public void clickPayNowBtn(){
        clickElement(payNowBtn);
    }

    public void inputCreditCardAndClickPay(String cardNumber, String expiryDate, String cvvNumber){
        inputCardNumber(cardNumber);
        inputExpiryDate(expiryDate);
        inputCvvNumber(cvvNumber);
        clickPayNowBtn();
    }

    public void inputOtpAndClickOkBtn(String otp){
        waitForVisibilityOfElementByTagName("iframe");
        sleepThread(2500);
        switchToFrameOrToParent(false, getElementsByTagName("iframe").size()-1);
        inputTextToElement(otpField, otp);
        clickElement(okBtn);
        switchToFrameOrToParent(true);
        checkElementInWebIsDisplayed();
    }
}
