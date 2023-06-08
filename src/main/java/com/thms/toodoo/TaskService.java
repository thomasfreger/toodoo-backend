package com.thms.toodoo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskDbSequenceService taskDbSequenceService;
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }
    public Optional<Task> singleTask(int taskId) {
        return taskRepository.findTaskByTaskId(taskId);
    }
    public Task createTask(String taskTitle, String taskDescription) {
        Task task = new Task(taskTitle, taskDescription);
        task.setTaskId(taskDbSequenceService.getSequenceNumber(Task.SEQUENCE_NAME));
        taskRepository.insert(task);
        return task;
    }
}
