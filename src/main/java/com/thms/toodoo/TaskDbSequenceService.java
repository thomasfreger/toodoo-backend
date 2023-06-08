package com.thms.toodoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class TaskDbSequenceService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        // get sequence number
        Query query = new Query(Criteria.where("id").is(sequenceName));
        // update the sequence
        Update update = new Update().inc("seq", 1);
        TaskDbSequence counter = mongoOperations.findAndModify(query,
                update, options().returnNew(true).upsert(true), TaskDbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
