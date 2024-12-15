package com.vigrudolf.productivity.Personal_Time_Management_System.exception;

public class UserDeleteException extends RuntimeException {
    public UserDeleteException(String message) {
        super(message);
    }

    public UserDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
