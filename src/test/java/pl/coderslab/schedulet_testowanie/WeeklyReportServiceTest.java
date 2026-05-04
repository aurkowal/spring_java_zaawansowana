package pl.coderslab.schedulet_testowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WeeklyReportServiceTest {

    @SpyBean
    private WeeklyReportService weeklyReportService;

    @Test
    void weeklyReportTest() {
        await().atMost(Duration.ofMinutes(1))
                .untilAsserted(() -> verify(weeklyReportService, atLeastOnce()).sendWeeklyReports());
    }

}