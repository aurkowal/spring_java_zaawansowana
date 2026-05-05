package pl.coderslab.RestAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


//public class MyAPITest {
//
//    @BeforeAll
//    public static void setUp() {
//        RestAssured.baseURI = "https://api.example.com";
//        RestAssured.port = 8080;
//    }
//
//    @Test
//    void testAPIEndpoint() {
//        given()
//                .when()
//                .get("/api/hello")
//                .then()
//                .statusCode(200)
//                .body(equalTo("Hello, World!"));
//    }
//}