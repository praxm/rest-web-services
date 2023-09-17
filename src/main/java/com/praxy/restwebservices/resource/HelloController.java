package com.praxy.restwebservices.resource;

import com.praxy.restwebservices.model.User;
import com.praxy.restwebservices.service.UserDaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.getAllusers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userDaoService.getUserById(id);
    }

    @DeleteMapping(path = "/user/{id}")
    public List<User> deleteUserById(@PathVariable("id")Integer id) {
        return userDaoService.deleteUserById(id);
    }

    @PostMapping(path = "/user")
    public List<User> createUser(@Valid @RequestBody User user) {
        return userDaoService.createUser(user);
    }

}
