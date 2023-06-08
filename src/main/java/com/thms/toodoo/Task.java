package com.thms.toodoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Transient
    public static final String SEQUENCE_NAME = "task_sequence";

    @Id
    private ObjectId id;
    private int taskId;
    private String title;
    private String description;
    private boolean completed;
    private String creationDate;
    private String dueDate;
    private List<Tag> tagIds;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.creationDate = LocalDateTime.now().toString();
        this.dueDate = LocalDateTime.now().toString();
        this.tagIds = new ArrayList<Tag>();
    }
}
