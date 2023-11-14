package com.example.TaskDemo.models;

import com.example.TaskDemo.enums.TaskStatus;
import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
=======
import lombok.Data;

@Entity
@Data
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String taskDescription;
    private String priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

<<<<<<< HEAD
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

=======
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
}
