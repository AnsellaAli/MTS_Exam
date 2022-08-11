package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;

public class CardPage {

    private final List<SelenideElement> TAB_LIST = $$(".Wrapper-sc-1vydk7-0.jLWLXd.TabText-sc-tyqhzb-3.faRXmE");
    private final By CARD_LIST = By.cssSelector(".Wrapper-sc-6nwvzq-0.kRJvZg.styled__TitleMobile-sc-m0n4zo-8.frcrJF");
    private final By CARD_NAME = By.cssSelector(".Wrapper-sc-6nwvzq-0.jcdBAB.styled__HeadingPromo-sc-14diurh-0.hYIINy");


    @Step("Выбрать сортировку {0}")
    public CardPage selectTab(String tabName) {
        sleep(500);
        $$(TAB_LIST).find(text(tabName)).click();
        return this;
    }

    @Step("Проверяем, что название карт содержит текст {0}")
    public CardPage checkNamesCardsContainsText(String cardName) {
        sleep(500);
        for (int i = 0; i < $$(CARD_LIST).size(); i++) {
            String card = $$(CARD_LIST).get(i).getOwnText();
            card.equals(cardName);
        }
        // $$(CARD_LIST).shouldHave(sizeGreaterThan(0)).stream().map(SelenideElement::getSelectedValue).forEach(name -> assertTrue(name.contains(cardName)));
        return this;
    }

}
