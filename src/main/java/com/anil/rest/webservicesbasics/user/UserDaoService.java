package com.anil.rest.webservicesbasics.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCounter = 3;

    static {
        users.add(new User(1, "AAA", new Date()));
        users.add(new User(2, "BBB", new Date()));
        users.add(new User(3, "CCC", new Date()));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User createUser(User user) {
        if (user.getId() == null || user.getId() == 0){
            user.setId(++userCounter);
        }
        users.add(user);
        return user;
    }

    public User findUser(int id) {
        for (User u : users
        ) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}
