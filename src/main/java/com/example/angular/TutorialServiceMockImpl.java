package com.example.angular;

import com.example.angular.model.Tutorial;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TutorialServiceMockImpl implements TutorialServiceInterface{
    List<Tutorial> tutorialsList = new ArrayList<>();
    @PostConstruct
    public void initService() {

        tutorialsList.add(new Tutorial(1, "java", "course", true));
        tutorialsList.add(new Tutorial(2, "js", "course", true));
        tutorialsList.add(new Tutorial(3, "basic", "test", true));
    }


    public List<Tutorial> getAllTutorials(String title){
        return tutorialsList;
    }

    public Tutorial getTutorialById(long id) throws IllegalArgumentException {
        Tutorial result = null;
        for (Tutorial tutorial : tutorialsList){
            if (id == tutorial.getId()){
                return tutorial;
            }
        }
       if (result == null )throw new IllegalArgumentException("not found");
       return null;
    }

    public Tutorial createTutorial(Tutorial tutorial){
        if (tutorial.getId() == 0){
            tutorial.setId(tutorialsList.size() + 1);
        }
        tutorialsList.add(tutorialsList.size(), tutorial);
        return tutorial;
    }

    public Tutorial updateTutorial(long id, Tutorial tutorial){
        int index = (int)id;
        tutorialsList.remove(index - 1);
        tutorialsList.add(tutorial);
        return tutorial;
    }

    @Override
    public Tutorial deleteTutorial(long id) {
        int index = (int)id;
        Tutorial tutorial = tutorialsList.get(index - 1);
        tutorialsList.remove(index - 1);
        return tutorial;
    }

    @Override
    public List<Tutorial> deleteAllTutorials() {
        tutorialsList.clear();
        return tutorialsList;
    }

//    @Override
    public List<Tutorial> findByPublished() {
        List<Tutorial> tutorials = new ArrayList<>();
        for (Tutorial tutorial : tutorialsList){
            if (tutorial.isPublished()){
                tutorials.add(tutorial);
            }
        }
        return tutorials;
    }
}
