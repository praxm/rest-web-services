package com.praxy.restwebservices.resource;

import com.praxy.restwebservices.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/users")
    public User getUsers() {
        return new User( 90,"dummy", "dummy");
    }

}
