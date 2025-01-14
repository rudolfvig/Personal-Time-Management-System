package com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@DiscriminatorValue("SINGLE_TASK")
public class SingleTask extends Task {

    private LocalDateTime startingTime;
    private LocalDateTime endTime;
    private Duration preparingTime;
    //private Reminder reminder;




}
