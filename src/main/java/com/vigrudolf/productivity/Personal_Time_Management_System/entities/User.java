package com.vigrudolf.productivity.Personal_Time_Management_System.entities;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedAt;

    @NotBlank(message = "Name is required")
    @Size(min = 4, max = 50)
    private String name;

    @NotBlank(message = "Email should not be empty")
    @Email(message = "Invalid email format") // Validates that the email is well-formed
    @Column(unique = true) // Ensures email is unique in the database
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotNull(message = "The user has to have a role, the user role is empty")
    @Enumerated(EnumType.STRING) // Maps enums as strings in the database
    private UserRole role;



}
