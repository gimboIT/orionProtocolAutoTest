package tests.trade;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.trade.model.OrderBook;

import static com.codeborne.selenide.Selenide.*;

public class OrionProtocolTradeApiTest {

    @Test
    void AskAndBidTest() throws JsonProcessingException {

        open("https://trade.orionprotocol.io/trade/ORN-USDT");
       // sleep(1000); // todo эвейтилити
        SelenideElement selenideElement1 = $(".TradeOrderBook_scrollContainer__1nxjs");
        SelenideElement selenideElement2 = selenideElement1.$$(".TradeOrderBookItem_root__1kdzi").last();
        SelenideElement selenideElement3 = selenideElement2.$(".TradeOrderBookItem_price__1cMkc");

        SelenideElement selenideElement4 = $$(".TradeOrderBook_items__5n-QJ").last();
        SelenideElement selenideElement5 = selenideElement4.$(".TradeOrderBookItem_price__1cMkc");
        String str = selenideElement5.getOwnText();


        double askUI = Double.parseDouble(selenideElement3.getOwnText());
        double bidUI = Double.parseDouble(str);


        String json = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://trade-exp.orionprotocol.io/backend/api/v1/orderbook?pair=ORN-USDT&depth=1")
                .body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        OrderBook orderBook = objectMapper.readValue(json,OrderBook.class);
        Double d = orderBook.getAsks().get(0).getPrice();
        Double d1 = orderBook.getBids().get(0).getPrice();


        Assertions.assertEquals(askUI,d);
        Assertions.assertEquals(bidUI,d1);


    }

}
