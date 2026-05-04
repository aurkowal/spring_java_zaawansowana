package pl.coderslab.schedulet_testowanie;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeeklyReportService {

    private static final Logger logger = LoggerFactory.getLogger(WeeklyReportService.class);

    @Scheduled(cron = "0 44 15 * * 1")
    public void sendWeeklyReports() {
        logger.info("Wysłano raport");
    }
}
