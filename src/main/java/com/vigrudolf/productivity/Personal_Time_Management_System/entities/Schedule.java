package com.vigrudolf.productivity.Personal_Time_Management_System.entities;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.SchedulePriority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.DateTimeException;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotBlank(message = "title is required")
    @Column(unique = true)
    private String title;

    private String description;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private SchedulePriority priority;

    @Enumerated(EnumType.STRING)
    private SchedulePriority status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;





}
