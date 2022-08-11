package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.OnlineBankPage;

public class OnlineBankPageTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода между формами при верно введённом телефоне")
    public void checkingTheTransitionBetweenForms() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("9040076046")
                .checkSwitchingWithGoodPhone();
    }

    @Test
    @DisplayName("Проверка сообщения при неверно введённом телефоне")
    public void checkingErrorPhone() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("979999")
                .checkError();
    }

    @Test
    @DisplayName("Проверка очищения поля ввода номера")
    public void checkingDeletePhone() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("9898998088")
                .clickDeletePhone();
    }
}
