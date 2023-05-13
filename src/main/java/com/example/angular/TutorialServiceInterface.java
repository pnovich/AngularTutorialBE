package com.example.angular;

import com.example.angular.model.Tutorial;

import java.util.List;

public interface TutorialServiceInterface {
    List<Tutorial> getAllTutorials(String title);
    Tutorial getTutorialById(long id) throws IllegalArgumentException;
    Tutorial createTutorial(Tutorial tutorial);
    Tutorial updateTutorial(long id, Tutorial tutorial);
    Tutorial deleteTutorial(long id);
    List<Tutorial> deleteAllTutorials();
    List<Tutorial> findByPublished();
}
