package com.vigrudolf.productivity.Personal_Time_Management_System.repositories;

import com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks.RecurringTask;
import com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks.RecurringTaskOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface RecurringTaskOccurrenceRepository extends JpaRepository<RecurringTaskOccurrence, Long> {

    // Find occurrences within a specific time range
    List<RecurringTaskOccurrence> findByOccurrenceTimeBetween(LocalDateTime start, LocalDateTime end);

    // Optionally, find by task (if you want all occurrences for a specific recurring task)
    List<RecurringTaskOccurrence> findByRecurringTask(RecurringTask recurringTask);
}
