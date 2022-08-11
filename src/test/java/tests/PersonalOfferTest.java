package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;

public class PersonalOfferTest extends BaseTest {

    @Test
    @DisplayName("Проверка правильности отображения сообщения с ошибкой при незаполненных данных")
    public void checkingInputsValidation() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickPhoneInput()
                .clickPassportInput()
                .clickFindOutLimitButton()
                .checkErrorText("Введите верные цифры", "Обязательное поле");
    }

    @Test
    @DisplayName("Проверка перехода на ввод кода из смс")
    public void checkingTransitionForm() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .enteringValues("9999999999", "8888888888")
                .clickFindOutLimitButton()
                .switchingToTheFormReceivingTheCodeFromSms();
    }

}
