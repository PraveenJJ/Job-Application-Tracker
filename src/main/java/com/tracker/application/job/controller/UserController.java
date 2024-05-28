package com.tracker.application.job.controller;

import com.jat.UserApi;
import com.jat.model.RegisterUserRequest;
import com.tracker.application.job.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This Rest Controller contains all APIs associated with user details.
 *
 * @author Praveen J
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    /**
     * This API registers user with the system
     *
     * @param registerUserRequest
     * @return 200 OK after successful registration
     */
    @Override
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid RegisterUserRequest registerUserRequest) {
        // calling service method to register user
        this.userService.registerUser(registerUserRequest);

        // returning 200 OK after successful registration
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
