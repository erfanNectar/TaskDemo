//<<<<<<< HEAD
//package com.example.TaskDemo.services;
//
//import com.example.TaskDemo.Dto.TaskDto;
//import com.example.TaskDemo.repository.TaskRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.scheduling.config.Task;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskService {
//    final TaskRepository taskRepository;
//
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    public TaskDto createTask(TaskDto taskDto){
//        Task task=convertToEntity(taskDto);
//        Task savedTask=taskRepository.save(task);
//        return convertToTaskDto(savedTask);
//    }
//
//private Task convertToEntity(TaskDto taskDto) {
//    Task task = new Task();
//    BeanUtils.copyProperties(taskDto, task);
//    task = setCreatedAt(LocalDateTime.now());
//    task = setUpdatedAt(LocalDateTime.now());
//}


