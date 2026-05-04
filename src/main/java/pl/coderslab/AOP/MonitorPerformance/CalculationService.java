package pl.coderslab.AOP.MonitorPerformance;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    @MonitorPerformance
    public double computePi(int terms) {
        double result = 0.0;
        for (int i = 0; i < terms; i++) {
            result += Math.pow(-1, i) / (2 * i + 1);
        }
        return result * 4;
    }
}
