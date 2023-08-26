package com.certification.taskmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private boolean completed = false;


}
