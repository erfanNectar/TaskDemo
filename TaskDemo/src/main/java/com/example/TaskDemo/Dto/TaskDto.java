package com.example.TaskDemo.Dto;

import com.example.TaskDemo.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String taskDescription;
    private String priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}
