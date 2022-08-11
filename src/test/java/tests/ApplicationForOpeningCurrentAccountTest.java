package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.devtools.v85.dom.model.BackendNode;
import pages.ApplicationForOpeningCurrentAccount;
import pages.HomePage;

public class ApplicationForOpeningCurrentAccountTest extends BaseTest {

    @Test
    @DisplayName("Проверка соответсвия города и офиса")
    public void checkSortCity(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToCurrencyControl();

        ApplicationForOpeningCurrentAccount applicationForOpeningCurrentAccount = new ApplicationForOpeningCurrentAccount();
        applicationForOpeningCurrentAccount.clickCityInput()
                .sortCityAndOffice();
    }

    @Test
    @DisplayName("Проверка соотвествия имени формы")
    public void checkNameForm(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToCurrencyControl();

        ApplicationForOpeningCurrentAccount applicationForOpeningCurrentAccount = new ApplicationForOpeningCurrentAccount();
        applicationForOpeningCurrentAccount.checkNameForm();
    }
}
