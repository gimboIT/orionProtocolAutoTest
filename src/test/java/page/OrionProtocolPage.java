package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OrionProtocolPage {

    SelenideElement tradeNav = $(byText("Trade"));
    SelenideElement StakeNav = $(byText("Stake"));
    SelenideElement BridgeNav = $(byText("Bridge"));

    public void goOnTrade() {
        tradeNav.click();
    }
}
