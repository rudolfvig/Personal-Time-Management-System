package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import lombok.Data;

@Data
public class UpdateUserPasswordDTO {

    private String oldPassword;
    private String newPassword;

}
