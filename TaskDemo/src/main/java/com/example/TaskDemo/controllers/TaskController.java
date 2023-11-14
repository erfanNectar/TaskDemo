package com.example.TaskDemo.controllers;

import com.example.TaskDemo.Dto.TaskDto;
import com.example.TaskDemo.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/add")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        TaskDto task=taskService.createTask(taskDto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }




}
