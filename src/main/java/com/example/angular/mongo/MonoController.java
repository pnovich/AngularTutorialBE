package com.example.angular.mongo;

import com.example.angular.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonoController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/mono/default")
    public String defaultString() {
        return "default string";
    }

    @GetMapping("/mono/all")
    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }

    @GetMapping("/mono/create/{stringId}")
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
