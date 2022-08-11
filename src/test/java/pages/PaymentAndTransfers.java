package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentAndTransfers {

    public final By SEARCH_INPUT = By.cssSelector("[placeholder=\"Поиск услуг, компаний или магазинов\"]");
    public final By SEARCH_LIST = By.cssSelector(".Search__Link-sc-1keknxh-1.igpAMU");
    public final By ERROR_MESSAGE_TEXT = By.cssSelector(".Wrapper-sc-1vydk7-0.eWunGH");
    public final By DELETE_SEARCH_INPUT = By.cssSelector("[data-testid=\"icon_baseX24/ic-close-1\"]");

    @Step("Нажатие на поле поиска")
    public PaymentAndTransfers clickSearchInput() {
        $(SEARCH_INPUT).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Ввод данных в поле поиска")
    public PaymentAndTransfers enteringValues(String searchName) {
        $(SEARCH_INPUT).sendKeys(searchName);
        return this;
    }

    @Step("Проверка соответсвие данных запросу")
    public PaymentAndTransfers checkSearchList() {
        String searchName = $(SEARCH_INPUT).getValue();
        clickSearchInput();
        for (int i = 0; i < $$(SEARCH_LIST).size(); i++) {
            String card = $$(SEARCH_LIST).get(i).getText();
            card.equals(searchName);
        }
        return this;
    }

    @Step("Проверка сообщения при некоректных данных")
    public PaymentAndTransfers checkErrorText() {
        $(ERROR_MESSAGE_TEXT).getText().equals("Ничего не найдено");
        return this;
    }

    @Step("Проверка очистки поля поиска")
    public PaymentAndTransfers deleteSearch() {
        $(DELETE_SEARCH_INPUT).click();
        $(SEARCH_INPUT).getValue().equals("");
        return this;
    }
}
