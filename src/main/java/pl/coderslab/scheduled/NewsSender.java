package pl.coderslab.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class NewsSender {

    @Scheduled(cron="0 * * * * ?")
    public void scheduleTaskEveryMinute() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Working task - " + dateFormat.format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduleTaskWithFixedDelay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Working task FixedDelay- " + dateFormat.format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduleTaskWithFixedRate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Working task FixRate - " + dateFormat.format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Working task InitialDelay - " + dateFormat.format(new Date()));
    }

}
