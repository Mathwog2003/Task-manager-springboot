package com.certification.taskmanager.service;

import com.certification.taskmanager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int intId = 1;

    public TaskEntity addTask(String title,String description, String deadline)
    {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadline); // To validate date format yyyy-mm-dd
        task.setCompleted(false);
        tasks.add(task);
        intId++;
        return task;
    }
    public ArrayList<TaskEntity> getTask()
    {
        return tasks;
    }
    public TaskEntity getTaskById(int id)
    {
        for(TaskEntity task : tasks)
        {
            if(task.getId() == id)
            {
                return task;
            }
        }
        return null;
    }
}
