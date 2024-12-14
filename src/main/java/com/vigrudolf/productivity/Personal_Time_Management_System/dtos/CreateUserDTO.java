package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.UserRole;
import lombok.Data;

@Data
public class CreateUserDTO {

    private String name;
    private String email;
    private String password;
    private UserRole role;

}
