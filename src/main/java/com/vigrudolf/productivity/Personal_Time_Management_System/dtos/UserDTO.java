package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    private UserRole role;
}
