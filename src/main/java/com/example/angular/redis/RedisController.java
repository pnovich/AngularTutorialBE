package com.example.angular.redis;

import com.example.angular.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisController {

    @Autowired
    TutorialRepository tutorialRepository;


    @GetMapping("/redis/default")
    public String defaultString() {

        return "default string";
    }

    @GetMapping("/redis/all")
    public Iterable<Tutorial> getAllTutorials(){

        return tutorialRepository.findAll();
    }

    @GetMapping("/redis/create/{stringId}")
    public Tutorial createTutorial(@PathVariable String stringId){
        Tutorial tutorial = new Tutorial();
        long id = Long.parseLong(stringId);
        tutorial.setId(id);
        tutorial.setTitle("title");
        tutorial.setDescription("description");
        tutorial.setPublished(true);
        tutorialRepository.save(tutorial);
        return  tutorial;
    }
}
