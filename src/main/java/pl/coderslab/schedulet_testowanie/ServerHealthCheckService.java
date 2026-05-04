package pl.coderslab.schedulet_testowanie;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServerHealthCheckService {
    private static final Logger logger = LoggerFactory.getLogger(ServerHealthCheckService.class);

    @Scheduled(cron = "0 0 * * * *")
    public void performHealthCheck() {
        logger.info("wynik sprawdzenia");
    }
}
