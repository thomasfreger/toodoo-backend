package com.thms.toodoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private ObjectId id;
    private int taskId;
    private String title;
    private String description;
    private boolean completed;
    private String creationDate;
    private String dueDate;
    private List<Tag> tagIds;
}
