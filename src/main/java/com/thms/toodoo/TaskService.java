package com.thms.toodoo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }
    public Optional<Task> singleTask(int taskId) {
        return taskRepository.findTaskByTaskId(taskId);
    }
}
