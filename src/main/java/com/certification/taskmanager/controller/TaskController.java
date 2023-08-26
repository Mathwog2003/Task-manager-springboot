package com.certification.taskmanager.controller;

import com.certification.taskmanager.DtoEntity.Dto;
import com.certification.taskmanager.entity.TaskEntity;
import com.certification.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<TaskEntity>> getTasks()
    {
        var tasks = taskService.getTask();
        if(tasks == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskEntity> addTask(@RequestBody Dto taskEntity)
    {
        taskService.addTask(taskEntity.getTitle(),taskEntity.getDescription(),taskEntity.getDeadline());
        return ResponseEntity.ok().build();

    }

}
