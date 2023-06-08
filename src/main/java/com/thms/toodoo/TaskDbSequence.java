package com.thms.toodoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks_db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDbSequence {

    @Id
    private String id;
    private int seq;
}
