package com.tracker.application.job.controller;

import com.tracker.application.job.model.User;
import com.tracker.application.job.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        System.out.println("User details -> " + user);
        this.userRepository.save(user);

    }

    @GetMapping("/user/{emailId}")
    public User getUser(@PathVariable(value = "emailId") String emailId) {
        return this.userRepository.findById(emailId).get();
    }

}
