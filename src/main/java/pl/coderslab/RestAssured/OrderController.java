package pl.coderslab.RestAssured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {

    @GetMapping("/api/order/{orderId}")
    public Map<String, Object> getOrder(@PathVariable String orderId) {

        return Map.of(
                "order_id", orderId,
                "customer", Map.of(
                        "name", "Jan Kowalski",
                        "email", "jan.kowalski@example.com",
                        "address", Map.of(
                                "street", "ul. Rolnicza 22",
                                "city", "Gdańsk",
                                "zip_code", "12345",
                                "country", "PL"
                        )
                ),
                "shipping", Map.of(
                        "method", "Kurier",
                        "cost", 10.00,
                        "estimated_delivery", "2024-04-15"
                )
        );
    }
}