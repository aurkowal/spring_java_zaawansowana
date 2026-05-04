package pl.coderslab.AOP.zadanie1;

import org.springframework.stereotype.Service;
import pl.coderslab.AOP.Logged;

@Service
public class ExampleService {

    @Logged
    public String processString(String input) {
        return "Processed: " + input;
    }

    @Logged
    public int multiply(int a, int b) {
        return a * b;
    }
}


