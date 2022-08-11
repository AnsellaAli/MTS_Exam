package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ApplicationForOpeningCurrentAccount {

    private final By NAME_FORM = By.cssSelector(".mts2-section-form__heading.light-dbo-from");
    private final By CITY_LIST = By.cssSelector(".nice-select.bid__form-input.inputselect.settlement-input .listDown .option");
    private final By OFFICE_LIST = By.cssSelector(".nice-select.bid__form-input.inputselect.ofis-input .option");
    private final By OPEN_CITY_LIST = By.cssSelector(".nice-select.bid__form-input.inputselect.settlement-input .current");
    private final By OPEN_OFFICE_LIST = By.cssSelector(".nice-select.bid__form-input.inputselect.ofis-input.open .option");

    @Step("Открытие вложенного списка городов")
    public ApplicationForOpeningCurrentAccount clickCityInput() {
        $(OPEN_CITY_LIST).click();
        return this;
    }

    @Step("Проверка соответствия имени формы")
    public ApplicationForOpeningCurrentAccount checkNameForm() {
        $(NAME_FORM).getText().equals("Заявка на открытие расчетного счета");
        return this;
    }

    @Step("Проверка соответсвия города и офиса")
    public ApplicationForOpeningCurrentAccount sortCityAndOffice() {
        for (int i = 1; i < $$(CITY_LIST).size(); i++) {
            String s = $$(CITY_LIST).get(i).getText();
            $$(CITY_LIST).find(Condition.text(s)).click();
            $(OPEN_CITY_LIST).click();
            $$(CITY_LIST).find(Condition.text(s)).click();
            sleep(5);
            for (int j = 1; j < $$(OFFICE_LIST).size(); j++) {
                String si = $$(OFFICE_LIST).get(j).getOwnText();
                String[] arrSi = si.split(":");
                String[] arrS = s.split(" ");
                arrSi[0].equals(arrS[0]);
            }
            clickCityInput();
        }
        return this;
    }
}
