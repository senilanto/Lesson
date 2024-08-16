package com.lesson.service;

import com.lesson.exceptions.BadRequestException;
import com.lesson.exceptions.ResourceNotFoundException;
import com.lesson.model.*;
import com.lesson.reposiitory.CatalogLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogLessonService {
    @Autowired
    private CatalogLessonRepository catalogLessonRepository;

    public CatalogLesson createCatalogLesson(CatalogLesson lesson) {
        if (lesson == null) {
            throw new BadRequestException("Lesson cannot be null");
        }
        return catalogLessonRepository.save(lesson);
    }

    public CatalogLesson updateCatalogLesson(CatalogLesson lesson) {
        if (lesson == null || !catalogLessonRepository.existsById(lesson.getLessonCode())) {
            throw new ResourceNotFoundException("Lesson not found for update");
        }
        return catalogLessonRepository.save(lesson);
    }

    public void deleteCatalogLesson(Long lessonCode) {
        catalogLessonRepository.deleteById(lessonCode);
    }

    public CatalogLesson getCatalogLessonById(Long lessonCode) {
        return catalogLessonRepository.findById(lessonCode).orElseThrow(() -> new ResourceNotFoundException("Lesson not found with ID: " + lessonCode));
    }

    public List<CatalogLesson> listAllCatalogLessons() {
        return catalogLessonRepository.findAll();
    }

    public TrainingCatalogResult getAllCatalogLessons(CriteriaInput criteria, int offset, int limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        List<CatalogLesson> lessons = catalogLessonRepository.findAll(pageRequest).getContent();
        List<CatalogLesson> filteredLessons = lessons.stream()
                .filter(x -> criteria.getCategory().toUpperCase().equals(x.getRole()))
                .collect(Collectors.toList());

        if (filteredLessons.isEmpty()) {
            throw new ResourceNotFoundException("No lessons found for the given criteria");
        }
        int totalResults = filteredLessons.size();
        PageInfo pageInfo = new PageInfo(offset, limit, totalResults);
        return new TrainingCatalogResult(pageInfo, filteredLessons);
    }
}
