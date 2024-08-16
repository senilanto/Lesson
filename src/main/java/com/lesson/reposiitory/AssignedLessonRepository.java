package com.lesson.reposiitory;

import com.lesson.model.AssignedLesson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssignedLessonRepository extends JpaRepository<AssignedLesson, Long> {

}
