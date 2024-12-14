package com.vigrudolf.productivity.Personal_Time_Management_System.repositories;

import com.vigrudolf.productivity.Personal_Time_Management_System.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
