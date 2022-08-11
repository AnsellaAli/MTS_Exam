package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.PaymentAndTransfers;

public class PaymentsAndTransfersTest extends BaseTest{

    @Test
    @DisplayName("Проверка соответсвия запроса в поиске и ответа при верном паметре поиска")
    public void checkSearchSort(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToPaymentAndTransfersPage();

        PaymentAndTransfers paymentAndTransfers = new PaymentAndTransfers();
        paymentAndTransfers.clickSearchInput()
                .enteringValues("связь")
                .checkSearchList();
    }

    @Test
    @DisplayName("Проверка сообщения при неверном паметре поиска")
    public void checkErrorText(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToPaymentAndTransfersPage();

        PaymentAndTransfers paymentAndTransfers = new PaymentAndTransfers();
        paymentAndTransfers.clickSearchInput()
                .enteringValues("сумка")
                .checkErrorText();
    }

    @Test
    @DisplayName("Проверка очищения поиска")
    public void checkDeleteInput(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToPaymentAndTransfersPage();

        PaymentAndTransfers paymentAndTransfers = new PaymentAndTransfers();
        paymentAndTransfers.clickSearchInput()
                .enteringValues("мобильный")
                .deleteSearch();
    }

}
