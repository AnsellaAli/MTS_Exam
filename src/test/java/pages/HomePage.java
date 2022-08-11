package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    //  private final By GO_TO_Cards = By.cssSelector("[href=\"/chastnim-licam/premium/premium-package/\"]");
    private final By GO_TO_CARDS = By.cssSelector("[href=\"/chastnim-licam/karti/\"]");
    private final By PHONE_INPUT = By.cssSelector("input[name='phoneNumber']");
    private final By PASSPORT_INPUT = By.cssSelector("input[name='passportNumberWithSerial']");
    private final By FiND_OUT_LIMIT_BUTTON = By.cssSelector("button.Wrapper-sc-48arcs-1.CtLfG.styled__FormButton-hl0ql7-1.dzPHqK");
    private final By TEXT_ERRORS_PHONE = By.cssSelector(".styled__FieldWrapper-wwecny-1.eOZCer:first-child .Wrapper-sc-1vydk7-0.OlnRe.HelperText-sc-jsokzo-0.hByJHf");
    private final By TEXT_ERRORS_PASSPORT = By.cssSelector(".styled__FieldWrapper-wwecny-1.eOZCer:last-child .Wrapper-sc-1vydk7-0.OlnRe.HelperText-sc-jsokzo-0.hByJHf");
    private final By SMS_CODE = By.cssSelector("[data-testid=\"confirmationField\"] [class=\"Wrapper-sc-1vydk7-0 BfQtf\"]");
    private final By ONLINE_BANK_PAGE = By.cssSelector("[href=\"https://payment.mts.ru/Auth/SignIn/\"]");
    private final By OPEN_MORE = By.cssSelector(".styled__MoreButton-sc-he1x93-2.fTfJnT");
    private final By GO_TO_PAYMENT_AND_TRANSFERS = By.cssSelector(".LinkWrapper-sc-a7l7fm-0.ktbVkT:last-child .Wrapper-sc-1vydk7-0.kKRlHI");

    private final By GO_TO_CURRENCY_CONTROL = By.cssSelector("[href=\"/malomu-biznesu/investicionnie-uslugi/currency-control/\"]");


    @Step("Открыть домашнюю страницу")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    @Step("Перейти в раздел 'Карты'")
    public HomePage clickGoToCards() {
        $(GO_TO_CARDS).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }

    @Step("Нажать на поле ввода номер телефона")
    public HomePage clickPhoneInput() {
        $(PHONE_INPUT).click();
        return this;
    }

    @Step("Нажать на поле ввода паспорт")
    public HomePage clickPassportInput() {
        $(PASSPORT_INPUT).click();
        return this;
    }

    @Step("Нажать на поле ввода номер телефона")
    public HomePage clickFindOutLimitButton() {
        $(FiND_OUT_LIMIT_BUTTON).click();
        return this;
    }

    @Step("Проверям текст ошибки")
    public HomePage checkErrorText(String errorTextPhone, String errorTextPassport) {
        $$(TEXT_ERRORS_PHONE).find(Condition.text(errorTextPhone));
        $$(TEXT_ERRORS_PASSPORT).find(Condition.text(errorTextPassport));
        return this;
    }

    @Step("Ввод дан в поле номер и паспорт")
    public HomePage enteringValues(String phone, String passport) {
        $(PHONE_INPUT).sendKeys(phone);
        $(PASSPORT_INPUT).sendKeys(passport);
        return this;
    }

    @Step("Проверка перехода на следующую форму")
    public HomePage switchingToTheFormReceivingTheCodeFromSms() {
        $(SMS_CODE).shouldHave(Condition.text("Код из СМС"));
        return this;
    }

    @Step("Проверка перехода на страницу онлайн банка")
    public HomePage clickToOnlineBank() {
        $(ONLINE_BANK_PAGE).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }

    @Step("Проверка перехода на страницу платежи и переводы")
    public HomePage clickGoToPaymentAndTransfersPage() {
        $(OPEN_MORE).shouldBe(Condition.visible).click();
        $(GO_TO_PAYMENT_AND_TRANSFERS).shouldBe(Condition.visible).click();
        return this;
    }


    @Step("Проверка перехода на страницу валютного контроля для малого бизнеса")
    public HomePage clickGoToCurrencyControl() {
        $(GO_TO_CURRENCY_CONTROL).click();
        return this;
    }
}
