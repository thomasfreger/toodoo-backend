package com.thms.toodoo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<List<Task>>(taskService.allTasks(), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Optional<Task>> getSingleTask(@PathVariable int taskId) {
        return new ResponseEntity<Optional<Task>>(taskService.singleTask(taskId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Task> createTsk(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Task>(taskService.createTask(payload.get("taskTitle"), payload.get("taskDescription")), HttpStatus.CREATED);
    }
}
