package com.vigrudolf.productivity.Personal_Time_Management_System.entities;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.TaskPriority;
import com.vigrudolf.productivity.Personal_Time_Management_System.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotBlank(message = "Title is required")
    @Column(unique = true)
    private String title;

    @Size(max = 500)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
