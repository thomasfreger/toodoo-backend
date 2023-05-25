package com.thms.toodoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private ObjectId id;
    private String title;

    public Tag(String title) {
        this.title = title;
    }
}
