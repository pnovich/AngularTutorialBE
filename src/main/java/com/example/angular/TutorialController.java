package com.example.angular;

import com.example.angular.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialServiceMockImpl tutorialService;

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) throws Exception{

        Tutorial tutorial = tutorialService.getTutorialById(id);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial savedTutorial = tutorialService.createTutorial(tutorial);
        return new ResponseEntity<>(savedTutorial, HttpStatus.OK);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Tutorial updatedTutorial = tutorialService.updateTutorial(id, tutorial);
        return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) throws  Exception {
        Tutorial tutorial = tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() throws Exception{
        List<Tutorial> tutorials = tutorialService.deleteAllTutorials();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        List<Tutorial> publishedTutorials = tutorialService.findByPublished();
        return  new ResponseEntity<>(publishedTutorials, HttpStatus.OK);
    }
}