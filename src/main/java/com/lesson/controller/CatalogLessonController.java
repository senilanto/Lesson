package com.lesson.controller;

import com.lesson.model.CatalogLesson;
import com.lesson.model.CriteriaInput;
import com.lesson.model.TrainingCatalogResult;
import com.lesson.service.CatalogLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog-lessons")
public class CatalogLessonController {
    @Autowired
    private CatalogLessonService catalogLessonService;

    @PostMapping
    public CatalogLesson createCatalogLesson(@RequestBody CatalogLesson lesson) {
        return catalogLessonService.createCatalogLesson(lesson);
    }

    @PutMapping
    public CatalogLesson updateCatalogLesson(@RequestBody CatalogLesson lesson) {
        return catalogLessonService.updateCatalogLesson(lesson);
    }

    @DeleteMapping("/{lessonCode}")
    public void deleteCatalogLesson(@PathVariable Long lessonCode) {
        catalogLessonService.deleteCatalogLesson(lessonCode);
    }

    @GetMapping("/{lessonCode}")
    public CatalogLesson getCatalogLessonById(@PathVariable Long lessonCode) {
        return catalogLessonService.getCatalogLessonById(lessonCode);
    }

    @GetMapping
    public List<CatalogLesson> listAllCatalogLessons() {
        return catalogLessonService.listAllCatalogLessons();
    }

    @GetMapping("/catalogs")
    public TrainingCatalogResult getAllCatalogLessons(
            @RequestParam CriteriaInput criteria,
            @RequestParam int offset,
            @RequestParam int limit) {
        return catalogLessonService.getAllCatalogLessons(criteria, offset, limit);
    }

}
