package com.example.TaskDemo.controllers;

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
    }




}
