package pl.coderslab.scheduled;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailyEmail() {
        System.out.println("Wysyłanie codziennego e-maila o 8:00");
        // logika wysyłania e-maila
    }
}

