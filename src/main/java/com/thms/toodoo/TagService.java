package com.thms.toodoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Tag createTag(String tagTitle, int taskId) {
        Tag tag = tagRepository.insert(new Tag(tagTitle));

        mongoTemplate.update(Task.class)
                .matching(Criteria.where("taskId").is(taskId))
                .apply(new Update().push("tagIds").value(tag))
                .first();

        return tag;
    }

    public Tag createTag(String tagTitle) {
        Tag tag = tagRepository.insert(new Tag(tagTitle));

        return tag;
    }

}
