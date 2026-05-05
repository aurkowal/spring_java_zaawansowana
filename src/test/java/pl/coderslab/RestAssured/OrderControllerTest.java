package pl.coderslab.RestAssured;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class OrderControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/api";
    }

    @Test
    public void testOrderDetails() {
        given()
                .contentType("application/json")
                .when()
                .get("/order/123")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("order_id", equalTo("123"))
                .body("customer.name", equalTo("Jan Kowalski"))
                .body("customer.email", equalTo("jan.kowalski@example.com"))
                .body("customer.address.street", equalTo("ul. Rolnicza 22"))
                .body("customer.address.city", equalTo("Gdańsk"))
                .body("customer.address.zip_code", equalTo("12345"))
                .body("customer.address.country", equalTo("PL"))
                .body("shipping.method", equalTo("Kurier"))
                .body("shipping.cost", equalTo(10.00f))
                .body("shipping.estimated_delivery", equalTo("2024-04-15"));

    }
}