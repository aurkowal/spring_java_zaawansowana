package pl.coderslab.AOP.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunnerUser implements CommandLineRunner {

    private final UserService userService;

    public TestRunnerUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        userService.addUser(new User(1L,"Jan"));
        userService.updateUser(new User(2L,"Anna"));
        userService.deleteUser(new User(3L,"Piotr"));
    }
}