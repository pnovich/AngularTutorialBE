package com.example.angular.model;

import java.util.List;

public class TutorialPage {
    int tutorialItems;
    List<Tutorial> tutorials;
    int totalPages;
    int currentPage;

    public TutorialPage(int tutorialItems, List<Tutorial> tutorials, int totalPages, int currentPage) {
        this.tutorialItems = tutorialItems;
        this.tutorials = tutorials;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public TutorialPage() {
    }

    @Override
    public String toString() {
        return "TutorialPage{" +
                "tutorialItems: " + tutorialItems +
                ", tutorials: [" + tutorials + "]" +
                ", totalPages : " + totalPages +
                ", currentPage : " + currentPage +
                '}';
    }

    public int getTutorialItems() {
        return tutorialItems;
    }

    public void setTutorialItems(int tutorialItems) {
        this.tutorialItems = tutorialItems;
    }

    public List<Tutorial> getTutorials() {
        return tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
