package com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks;


import jakarta.persistence.*;
import lombok.Data;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
public class RecurringTaskOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime occurrenceStartTime; // Time of this specific occurrence
    private LocalDateTime occurrenceEndTime;

    private Duration occurrencePreparingTime; // Preparing time for this occurrence

    @ManyToOne
    @JoinColumn(name = "recurring_task_id")
    private RecurringTask recurringTask; // Reference to the parent recurring task

}
