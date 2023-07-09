package tests.swap;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://trade.orionprotocol.io/swap";
    }

    @BeforeEach
    void before() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("");
    }

    @AfterEach
    void after() {
        Attach.makeScreenshot("LastScreen");
        closeWebDriver();
    }

}
