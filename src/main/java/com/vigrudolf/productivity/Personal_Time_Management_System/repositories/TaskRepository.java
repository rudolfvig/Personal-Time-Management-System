package com.vigrudolf.productivity.Personal_Time_Management_System.repositories;

import com.vigrudolf.productivity.Personal_Time_Management_System.entities.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
