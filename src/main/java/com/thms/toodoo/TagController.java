package com.thms.toodoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/tags")
@CrossOrigin(origins = "*")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Tag>(tagService.createTag(payload.get("tagTitle"), Integer.parseInt(payload.get("taskId"))), HttpStatus.CREATED);
    }
}
