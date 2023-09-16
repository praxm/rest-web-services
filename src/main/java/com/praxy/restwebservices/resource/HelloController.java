package com.praxy.restwebservices.resource;

import com.praxy.restwebservices.model.User;
import com.praxy.restwebservices.service.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
