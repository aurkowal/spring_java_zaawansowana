package pl.coderslab.RestAssured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @GetMapping("/api/calculate")
    public int calculate(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam String operation
    ) {
        return switch (operation) {
            case "add" -> a + b;
            case "substract" -> a - b;
            default -> throw new IllegalArgumentException("Nieznana operacja: " + operation);
        };
    }
}
