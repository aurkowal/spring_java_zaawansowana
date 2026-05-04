package pl.coderslab.scheduled;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileReaderService {


    public List<User> readFile(String path) {
        log.info("Start processing of file [{}]", path);
        Path file = Paths.get(path);
        List<User> users = null;
        try (Stream<String> stream = Files.lines(file, StandardCharsets.UTF_8)) {
            users = stream
                    .skip(1) // skip header
                    .map(line -> line.split(","))
                    .map(this::mapToUser)
                    .toList();
        } catch (IOException e) {
            log.info("Exception {}", e.getMessage(), e);
        }

        try {
            Files.delete(file);
        } catch (IOException e) {
            log.info("Exception when deleting file {}", e.getMessage(), e);
        }

        return users;
    }

    private User mapToUser(String[] parts) {
        return User.builder()
                .name(parts[0])
                .surname(parts[1])
                .email(parts[2])
                .dateOfBirth(LocalDate.parse(parts[3]))
                .build();
    }
}


