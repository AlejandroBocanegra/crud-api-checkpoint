package com.galvanize.crudapicheckpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private final UserRepository repository;

    public UserController(UserRepository repository) {this.repository= repository;}

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.repository.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return this.repository.save(user);
    }
}