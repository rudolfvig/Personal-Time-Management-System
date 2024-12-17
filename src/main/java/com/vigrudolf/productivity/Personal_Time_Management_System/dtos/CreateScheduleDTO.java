package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.TaskPriority;
import com.vigrudolf.productivity.Personal_Time_Management_System.enums.TaskStatus;

public class CreateScheduleDTO {

    private String title;
    private String description;
    private String startTime;
    private String endTime;
    private TaskPriority priority;
    private TaskStatus status;
    private long userId;
}
