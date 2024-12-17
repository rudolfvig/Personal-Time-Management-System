package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.UserRole;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    @Positive
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    private String name;
    private String email;
    private UserRole role;
    private String password;
}
