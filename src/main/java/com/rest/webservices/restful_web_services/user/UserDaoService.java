package com.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount, "Buğra", LocalDate.now().minusYears(28)));
        users.add(new User(++usersCount, "Nazlı", LocalDate.now().minusYears(34)));
        users.add(new User(++usersCount, "Rio", LocalDate.now().minusYears(5)));
        users.add(new User(++usersCount, "Karina", LocalDate.now().minusYears(2)));
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return  users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
