package com.vigrudolf.productivity.Personal_Time_Management_System.exception;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UpdateUserPasswordDTO;

public class UpdatePasswordException extends RuntimeException{
    public UpdatePasswordException(String message) {
        super(message);
    }
}
