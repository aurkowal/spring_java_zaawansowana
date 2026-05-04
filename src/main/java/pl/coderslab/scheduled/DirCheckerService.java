package pl.coderslab.scheduled;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class DirCheckerService {

    private final FileReaderService readerService;
    private final String directoryToCheck;
    private final UserRepository repository;

    public DirCheckerService(FileReaderService readerService, @Value("${dir.checker.directory}") String directory, UserRepository repository) {
        this.readerService = readerService;
        this.directoryToCheck = directory;
        this.repository = repository;
    }

    @Scheduled(cron = "0 0/5 * ? * *")
    public void processDirectory() {
        try (Stream<Path> stream = Files.list(Paths.get(directoryToCheck))) {
            stream.filter(file -> !Files.isDirectory(file))
                    .forEach(p -> repository.saveAll(readerService.readFile(p.toString())));


        } catch (IOException e) {
            log.info("Exception occurred: {}", e.getMessage(), e);
        }
    }
}
