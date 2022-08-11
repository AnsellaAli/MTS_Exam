package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OnlineBankPage {

    private final By PHONE_INPUT = By.cssSelector("[name='phone']");
    private final By CONTINUE_BUTTON = By.cssSelector("[class=\"sc-bdfBwQ joyPHQ\"]");
    private final By DELETE_PHONE = By.cssSelector("[class=\"Svg-sc-1cvehoj-1 gEwQyG\"]");
    private final By SWITCHING_TO_THE_NEXT_FORM = By.cssSelector("[class=\"sc-kEjbxe jbJDWL\"]");
    private final By ERROR_TEXT = By.cssSelector("[data-testid=\"error\"]");


    @Step("Нажать на форму для ввода номера")
    public OnlineBankPage clickPhoneInput() {
        $(PHONE_INPUT).click();
        return this;
    }

    @Step("Нажать на кнопку далее")
    public OnlineBankPage clickContinueButton() {
        $(CONTINUE_BUTTON).click();
        return this;
    }

    @Step("Проверка удаления содержимого в поле номер")
    public OnlineBankPage clickDeletePhone() {
        $(DELETE_PHONE).click();
        $(PHONE_INPUT).getValue().equals("+7");
        return this;
    }

    @Step("Ввод данных в поле номер")
    public OnlineBankPage enteringValues(String phone) {
        $(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    @Step("Проверка перехода на форму с полностью введённым номером")
    public OnlineBankPage checkSwitchingWithGoodPhone() {
        String phone = $(PHONE_INPUT).getValue();
        String[] phoneSize = phone.split("");
        clickContinueButton();
        if (phoneSize.length == 16) {
            $(SWITCHING_TO_THE_NEXT_FORM).shouldHave(Condition.text("Введите код из SMS"));
        }
        return this;
    }

    @Step("Проверка текста ошибки при с неправильно введённым номером")
    public OnlineBankPage checkError() {
        String phone = $(PHONE_INPUT).getValue();
        String[] phoneSize = phone.split("");
        clickContinueButton();
        if (phoneSize.length != 16) {
            $(ERROR_TEXT).shouldHave(Condition.text("Номер телефона должен содержать 10 цифр, например, +7 912 345-67-89"));
        }
        return this;
    }

}
