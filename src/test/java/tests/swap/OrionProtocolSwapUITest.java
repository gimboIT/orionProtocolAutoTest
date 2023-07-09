package tests.swap;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OrionProtocolSwapUITest extends TestBase {

    public static String DEFAULT_TOKEN_FIRST = "ORN";
    public static String DEFAULT_TOKEN_SECOND = "USDT";

    @Owner("Timurka")
    @Test
    void DefaultTokenTest() {
        step("Проверка что первый токен  по умолчанию выбран правильно",() -> {
            $(".SwapSpending_currencyDropdown__39hco").shouldHave(Condition.text(DEFAULT_TOKEN_FIRST));
        });
        step("Проверка что в второй токен по умолчанию выбран правильно",() -> {
            $(".SwapReceiving_currencyDropdown__2nC8Q").shouldHave(Condition.text(DEFAULT_TOKEN_SECOND));
        });

    }
    @Owner("Timurka")
    @Test
    void SwapScheduleCheckShow() {
        step("Нажали на кнопку <Go It>",() -> {
            $(".SwapInfo_button__WqCKe").click();
        });
        step("Проверка что график показывает правильный токен",() -> {
            $(".SwapChart_currentPrice__1p5iV").shouldHave(Condition.text(DEFAULT_TOKEN_SECOND));
        });
    }
    @Owner("Timurka")
    @Test
    void DefaultExchangeTest() {
        step("Проверка что показывает по умолчанию Binance",() -> {
            $(".HeaderChangeNetwork_buttonTitle__3Glg3").shouldHave(Condition.text("Binance Smart Chain"));
        });
    }
    @Owner("Timurka")
    @Test
    void changeFirstToken() {
        step("Нажали на первый токен",() -> {
            $(".SwapSpending_currencyPicker__fZoFP").click();
        });
        step("Выбрали BUSD",() -> {
            $(byText("BUSD")).click();
        });
        step("Проверяем что там лежит BUSD",() -> {
            $(".SwapSpending_currencyPicker__fZoFP").shouldHave(Condition.text("BUSD"));
        });
        step("Очистили local Storage",() -> {
            localStorage().clear();
        });
    }
}
