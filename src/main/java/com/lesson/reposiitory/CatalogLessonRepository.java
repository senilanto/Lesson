package com.lesson.reposiitory;

import com.lesson.model.CatalogLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogLessonRepository  extends JpaRepository<CatalogLesson, Long> {
}
