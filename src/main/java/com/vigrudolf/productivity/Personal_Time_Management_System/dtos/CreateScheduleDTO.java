package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import com.vigrudolf.productivity.Personal_Time_Management_System.enums.SchedulePriority;
import com.vigrudolf.productivity.Personal_Time_Management_System.enums.ScheduleStatus;

public class CreateScheduleDTO {

    private String title;
    private String description;
    private String startTime;
    private String endTime;
    private SchedulePriority priority;
    private ScheduleStatus status;
    private long userId;
}
