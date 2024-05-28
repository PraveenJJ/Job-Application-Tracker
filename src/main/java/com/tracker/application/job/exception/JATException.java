package com.tracker.application.job.exception;

import com.tracker.application.job.model.enums.JATError;

public class JATException extends RuntimeException {

    private int statusCode;

    private String jatErrorMessage;

    public JATException(JATError jatError) {
        super(jatError.getErrorMessage());
        this.statusCode = jatError.getStatusCode();
        this.jatErrorMessage = jatError.getErrorMessage();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getJatErrorMessage() {
        return jatErrorMessage;
    }

}
