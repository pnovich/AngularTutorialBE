package com.example.angular.redis;

import com.example.angular.model.Tutorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends CrudRepository<Tutorial, Long> {
}
