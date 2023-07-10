package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TokenApiTest {

    String checkedValue = "ALICE-BNB";

    @Test
    void getAllTokensTest() throws JsonProcessingException {

//
//
//        String json = given()
//                .contentType(ContentType.JSON)
//                .get("https://trade-exp.orionprotocol.io/backend/api/v1/pairs/list")
//                .getBody().as().asString();
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String[] tokens = objectMapper.readValue(json,String[].class);
//        boolean tre = false;
//        for (String token : tokens) {
//            if(token.equals(checkedValue)) tre = true;
//        }
//        assertTrue(tre);

    }
}
