
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PayrollAPITest {

    @Test
    public void testCreateEmployee() {
        RestAssured.given()
                .contentType("application/json")
                .body("{"name": "John", "salary": 45000}")
        .when()
                .post("https://dummy-api.com/employees")
        .then()
                .statusCode(201)
                .body("name", equalTo("John"));
    }

    @Test
    public void testRunPayroll() {
        RestAssured.given()
        .when()
                .post("https://dummy-api.com/runPayroll")
        .then()
                .statusCode(200)
                .body("status", equalTo("Success"));
    }
}
