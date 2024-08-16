package com.lesson.controller;

import com.lesson.model.AssignedLesson;
import com.lesson.model.CriteriaInput;
import com.lesson.model.TrainingAssignedResult;
import com.lesson.service.AssignedLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assigned-lessons")
public class AssignedLessonController {
    @Autowired
    private AssignedLessonService assignedLessonService;

    @PostMapping
    public ResponseEntity<AssignedLesson> createAssignedLesson(@RequestBody AssignedLesson lesson) {
        AssignedLesson assignedLesson= assignedLessonService.createAssignedLesson(lesson);
        return new ResponseEntity<>(assignedLesson, HttpStatus.CREATED);
    }

    @PutMapping
    public AssignedLesson updateAssignedLesson(@RequestBody AssignedLesson lesson) {
        return assignedLessonService.updateAssignedLesson(lesson);
    }

    @DeleteMapping("/{lessonCode}")
    public void deleteAssignedLesson(@PathVariable Long lessonCode) {
        assignedLessonService.deleteAssignedLesson(lessonCode);
    }

    @GetMapping("/{lessonCode}")
    public AssignedLesson getAssignedLessonById(@PathVariable Long lessonCode) {
        return assignedLessonService.getAssignedLessonById(lessonCode);
    }

    @GetMapping
    public List<AssignedLesson> listAllAssignedLessons() {
        return assignedLessonService.listAllAssignedLessons();
    }

    @GetMapping("/lesson")
    public TrainingAssignedResult getAllAssignedLessons(
            @RequestParam CriteriaInput criteria,
            @RequestParam int offset,
            @RequestParam int limit) {
        return assignedLessonService.getAllAssignedLessons(criteria, offset, limit);
    }
}
