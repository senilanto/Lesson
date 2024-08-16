package com.lesson.service;

import com.lesson.exceptions.BadRequestException;
import com.lesson.exceptions.ResourceNotFoundException;
import com.lesson.model.*;
import com.lesson.reposiitory.AssignedLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AssignedLessonService {
    @Autowired
    private AssignedLessonRepository assignedLessonRepository;

    public AssignedLesson createAssignedLesson(AssignedLesson lesson) {
        if (lesson == null) {
            throw new BadRequestException("Lesson cannot be null");
        }
        return assignedLessonRepository.save(lesson);
    }

    public AssignedLesson updateAssignedLesson(AssignedLesson lesson) {
        if (lesson == null || !assignedLessonRepository.existsById(lesson.getLessonCode())) {
            throw new ResourceNotFoundException("Lesson not found for update");
        }
        return assignedLessonRepository.save(lesson);
    }

    public void deleteAssignedLesson(Long lessonCode) {
        assignedLessonRepository.deleteById(lessonCode);
    }

    public AssignedLesson getAssignedLessonById(Long lessonCode) {
        return assignedLessonRepository.findById(lessonCode).orElseThrow(() -> new ResourceNotFoundException("Lesson not found with ID: " + lessonCode));
    }

    public List<AssignedLesson> listAllAssignedLessons() {
        return assignedLessonRepository.findAll();
    }

    public TrainingAssignedResult getAllAssignedLessons(CriteriaInput criteria, int offset, int limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        List<AssignedLesson> lessons = assignedLessonRepository.findAll(pageRequest).getContent();
        List<AssignedLesson> filteredLessons = lessons.stream()
                .filter(x -> x.getCategory().equalsIgnoreCase(criteria.getCategory()))
                .collect(Collectors.toList());

        if (filteredLessons.isEmpty()) {
            throw new ResourceNotFoundException("No lessons found for the given criteria");
        }
        int totalResults = filteredLessons.size();
        PageInfo pageInfo = new PageInfo(offset, limit, totalResults);
        return new TrainingAssignedResult(pageInfo, filteredLessons);
    }


}
