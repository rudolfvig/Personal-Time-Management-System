package com.vigrudolf.productivity.Personal_Time_Management_System.entities;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates unique IDs
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotBlank(message = "Name is required") // Ensures the name field is not blank
    private String name;

    @Email(message = "Invalid email format") // Validates that the email is well-formed
    @Column(unique = true) // Ensures email is unique in the database
    private String email;

    @NotBlank(message = "Password is required") // Ensures the password is not blank
    @Size(min = 8, message = "Password must be at least 8 characters") // Enforces password length
    private String password;

    @Enumerated(EnumType.STRING) // Maps enums as strings in the database
    private UserRole role; // Role field referencing an enum



}
