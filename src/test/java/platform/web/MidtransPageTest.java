package platform.web;

import common.BaseWebTest;
import org.junit.Test;
import platform.web.pages.MidtransPage;

public class MidtransPageTest extends BaseWebTest {
    private MidtransPage midtransPage;
    //Number 1 Scenario 2
    @Test()
    public void Midtrans_Positive() {
        getWebDriver().get("https://demo.midtrans.com/#");
        midtransPage = new MidtransPage(getWebDriver());
        midtransPage.checkElementInWebIsDisplayed();
        midtransPage.clickBuyButton();
        midtransPage.checkShoppingCartSpanIsDisplayed();
        midtransPage.clickCheckoutButton();
        midtransPage.clickContinueButton();
        midtransPage.clickCreditOrDebitCard();
        midtransPage.inputCreditCardAndClickPay("4811111111111114", "12/24", "123");
        midtransPage.inputOtpAndClickOkBtn("112233");
        midtransPage.checkElementInWebIsDisplayed();
    }

    @Test()
    public void Midtrans_Negative() {
        getWebDriver().get("https://demo.midtrans.com/#");
        midtransPage = new MidtransPage(getWebDriver());
        midtransPage.checkElementInWebIsDisplayed();
        midtransPage.clickBuyButton();
        midtransPage.checkShoppingCartSpanIsDisplayed();
        midtransPage.clickCheckoutButton();
        midtransPage.clickContinueButton();
        midtransPage.clickCreditOrDebitCard();
        midtransPage.inputCreditCardAndClickPay("4911111111111113", "02/20", "123");
        midtransPage.assertPayNowStillAppear();
    }
}
