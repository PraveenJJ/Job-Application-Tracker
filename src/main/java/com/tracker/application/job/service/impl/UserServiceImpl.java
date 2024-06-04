package com.tracker.application.job.service.impl;

import com.jat.model.RegisterUserRequest;
import com.tracker.application.job.exception.JATException;
import com.tracker.application.job.model.User;
import com.tracker.application.job.model.enums.JATError;
import com.tracker.application.job.repository.UserRepository;
import com.tracker.application.job.service.UserService;
import com.tracker.application.job.utility.JatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(RegisterUserRequest registerUserRequest) {
        // checking if user already exists with email id
        Optional<User> optional = this.userRepository.findById(registerUserRequest.getEmailId());

        // throwing exception if user exists
        if (optional.isPresent()) {
            throw new JATException(JATError.USER_ALREADY_EXISTS);
        }

        // saving new user details
        this.saveUserInDB(JatUtility.map(registerUserRequest));
    }

    @Transactional
    private void saveUserInDB(User user) {
        this.userRepository.save(user);
    }

}
