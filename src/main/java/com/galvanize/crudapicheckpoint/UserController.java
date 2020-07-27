package com.galvanize.crudapicheckpoint;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User newUser) {
        return this.repository.save(newUser);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        if (this.repository.findById(id).isPresent()) {
            return this.repository.findById(id).get();
        } else {
            return null;
        }
    }

    @PatchMapping("/users/{id}")
    public User findUserById(@PathVariable("id") Long id, @RequestBody User userUpdate) {
        Optional<User> findId = this.repository.findById(id);
        if (findId.isPresent()) {
            User getUserRow = findId.get();

            if (userUpdate.getEmail() != null) {
                getUserRow.setEmail(userUpdate.getEmail());
            }

            if (userUpdate.getPassword() != null) {
                getUserRow.setPassword(userUpdate.getPassword());
            }

            this.repository.save(userUpdate);

            return userUpdate;

        } else {
            return null;
        }
    }

    @DeleteMapping("/users/{id}")
    public Long deleteUserById(@PathVariable("id") Long deleteUser) {
        this.repository.deleteById(deleteUser);
        return this.repository.count();
    }

    // @PostMapping("/users/authenticate")
    // public String updateUserByEmail (@RequestBody User authCheck) {

    // }

}
