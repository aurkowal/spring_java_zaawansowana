package pl.coderslab.RestAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class CalculateControllerTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/api";
    }

    @Test
    void testAddMethod() {
        given()
                .queryParam("operation", "add")
                .queryParam("a", 5)
                .queryParam("b", 3)
                .when()
                .get("/calculate")
                .then()
                .statusCode(200)
                .body(equalTo("8"));
    }

    @Test
    void testSubstractMethod() {
        given()
                .queryParam("operation", "substract")
                .queryParam("a", 5)
                .queryParam("b", 3)
                .when()
                .get("/calculate")
                .then()
                .statusCode(200)
                .body(equalTo("2"));
    }
}