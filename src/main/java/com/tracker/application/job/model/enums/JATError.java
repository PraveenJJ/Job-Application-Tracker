package com.tracker.application.job.model.enums;

public enum JATError {

    USER_ALREADY_EXISTS(400, "User already exists with this email id. Please try with a different email id."),
    USER_NOT_FOUND(404, "User not found for given email id."),
    JOB_APPLICATION_NOT_FOUND(404, "Job Application doesn't exist for the given JAT ID."),
    DATABASE_CONNECTION_FAILED(404, "Failed to connect to the database."),
    RESOURCE_NOT_FOUND(404, "Requested resource not found."),
    UNAUTHORIZED_ACCESS(403, "Unauthorized access attempt.");

    private final int statusCode;
    private final String errorMessage;

    JATError(int code, String message) {
        this.statusCode = code;
        this.errorMessage = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
