package tests.swap;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.OrionProtocolSwapPage;

public class OrionProtocolSwapUITest extends TestBase {
    public static String TEST_TOKEN = "BUSD";

    OrionProtocolSwapPage orionProtocolSwapPage = new OrionProtocolSwapPage();

    @Owner("Timurka")
    @DisplayName("Проверка токенов по умолчанию")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void defaultTokenTest() {
        orionProtocolSwapPage
                .openBrowser()
                .checkDefaultFirstToken()
                .checkDefaultSecondToken();
    }
    @Owner("Timurka")
    @DisplayName("Проверка графика что он показывает токен по умолчанию")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void swapScheduleCheckShow() {
        orionProtocolSwapPage
                .openBrowser()
                .checkChartSwapToken();
    }
    @Owner("Timurka")
    @DisplayName("Проверка что показывает биржу по умолчанию")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void defaultExchangeTest() {
        orionProtocolSwapPage
                .openBrowser()
                .defaultExchangeCheck();
    }
    @Owner("Timurka")
    @DisplayName("Проверка что можно менять токен на другой")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void changeFirstTokenTest() {
        orionProtocolSwapPage
                .openBrowser()
                .changeTokenCheck(TEST_TOKEN);
    }
}
