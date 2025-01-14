package com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.RecurrencePattern;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class RecurringTask extends Task{

    @Enumerated(EnumType.STRING)
    private RecurrencePattern recurrencePattern; // DAILY, WEEKLY, MONTHLY, YEARLY

    private LocalDateTime nextOccurrence; // The date of the next recurrence

    private LocalDateTime endOfRecurrence;

    @OneToMany(mappedBy = "recurringTask", cascade = CascadeType.ALL)
    private List<RecurringTaskOccurrence> occurrences; // Store occurrences for each recurring task
}
