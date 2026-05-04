package pl.coderslab.scheduled;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    public void saveAll(List<User> users) {
        System.out.println("Zapisano " + users.size() + " użytkowników");
    }
}
