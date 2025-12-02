package Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class APIUtil {

    public static Response get(String baseUri, String path, Map<String, ?> queryParams) {
            return RestAssured.given()
                    .baseUri(baseUri)
                    .queryParams(queryParams)
                    .when()
                    .get(path)
                    .andReturn();
        }


        public static Response post(String baseUri, String path, Object body) {
            return RestAssured.given()
                    .baseUri(baseUri)
                    .header("Content-Type", "application/json")
                    .body(body)
                    .when()
                    .post(path)
                    .andReturn();
        }






}
