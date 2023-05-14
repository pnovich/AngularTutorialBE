package com.example.angular;
import com.example.angular.model.Tutorial;
import com.example.angular.model.TutorialPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")


@RestController
public class TestController {

    @Autowired
    TutorialServiceMockImpl tutorialService;

    @GetMapping("/")
    public String getDefaultString() {

        return "default string works";
    }

    @GetMapping("api/tutorials")
    public ResponseEntity<TutorialPage> getAllTutorialsWithPage(@RequestParam(required = false) Integer page,
                                                                Integer size) {
        String title = "";
        List<Tutorial> tutorials = tutorialService.getAllTutorials(title);
        TutorialPage tutorialPage = new TutorialPage();
        tutorialPage.setTotalPages(1);
        tutorialPage.setCurrentPage(1);
        tutorialPage.setTutorialItems(2);
        tutorialPage.setTutorials(tutorials);
        return new ResponseEntity<>(tutorialPage, HttpStatus.OK);
    }

    @GetMapping("/old/api/tutorials")
    public ResponseEntity<List<Tutorial>> getOldAllTutorials(@RequestParam(required = false) String title) {
        return new ResponseEntity<>(tutorialService.getAllTutorials(title), HttpStatus.OK);
    }
}