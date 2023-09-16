package com.praxy.restwebservices.service;

import com.praxy.restwebservices.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
    private static ArrayList<User> users = new ArrayList();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eva", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> getAllusers() {
        return users;
    }

    public User getUserById(Integer id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }
}
