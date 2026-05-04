package pl.coderslab.AOP.zadanie1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final ExampleService exampleService;

    public TestRunner(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Override
    public void run(String... args) {
        exampleService.processString("Hello");
        exampleService.multiply(3, 4);
    }
}