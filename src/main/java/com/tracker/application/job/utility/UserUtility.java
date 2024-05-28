package com.tracker.application.job.utility;

import com.jat.model.RegisterUserRequest;
import com.tracker.application.job.model.User;

public final class UserUtility {

    private UserUtility() {
    }

    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmailId(registerUserRequest.getEmailId());
        user.setPwd(registerUserRequest.getPwd());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        return user;
    }

}
