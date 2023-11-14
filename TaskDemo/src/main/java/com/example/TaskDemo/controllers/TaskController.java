package com.example.TaskDemo.controllers;

<<<<<<< HEAD
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
=======
import com.example.TaskDemo.Dto.TaskGetDto;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


    @GetMapping
    public String user(){
        return "hello DEVECHI!";
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
    }




}
