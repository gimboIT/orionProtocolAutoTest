package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OrionProtocolSwapPage {

    public static String DEFAULT_TOKEN_FIRST = "ORN";
    public static String DEFAULT_TOKEN_SECOND = "USDT";

    SelenideElement
            firstToken = $(".SwapSpending_currencyDropdown__39hco"),
            secondToken = $(".SwapReceiving_currencyDropdown__2nC8Q"),
            buttonGoIt = $(".SwapInfo_button__WqCKe"),
            tokenOnSwapChart = $(".SwapChart_currentPrice__1p5iV"),
            exchange = $(".HeaderChangeNetwork_buttonTitle__3Glg3");
    @Step("Открыли браузер")
    public OrionProtocolSwapPage openBrowser() {
        open("");
        return this;
    }
    @Step("Проверяем первый токен")
    public OrionProtocolSwapPage checkDefaultFirstToken() {
        firstToken.shouldHave(Condition.text(DEFAULT_TOKEN_FIRST));
        return this;
    }

    @Step("Проверяем второй токен")
    public OrionProtocolSwapPage checkDefaultSecondToken() {
        secondToken.shouldHave(Condition.text(DEFAULT_TOKEN_SECOND));
        return this;
    }

    @Step("Проверяем отображение Токена на графике")
    public OrionProtocolSwapPage checkChartSwapToken() {
        buttonGoIt.click();
        tokenOnSwapChart.shouldHave(Condition.text(DEFAULT_TOKEN_SECOND));
        return this;
    }

    @Step("Проверка что показывает по умолчанию Binance")
    public OrionProtocolSwapPage defaultExchangeCheck() {
        exchange.shouldHave(Condition.text("Binance Smart Chain"));
        return this;
    }

    @Step
    public OrionProtocolSwapPage changeTokenCheck(String token) {
        firstToken.click();
        $(byText(token)).click();
        $(".SwapSpending_currencyPicker__fZoFP").shouldHave(Condition.text(token));
        localStorage().clear();
        return this;
    }

}
