package com.example.TaskDemo.models;

import com.example.TaskDemo.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String taskDescription;
    private String priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}
