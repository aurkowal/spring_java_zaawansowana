package pl.coderslab.AOP.bookService;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coderslab.AOP.MonitorPerformance.CalculationService;

@Component
public class TestRunnerCalc implements CommandLineRunner {

    private final CalculationService calculationService;

    public TestRunnerCalc(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @Override
    public void run(String... args) {
        calculationService.computePi(1_000_000);
    }
}