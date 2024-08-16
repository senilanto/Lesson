package com.lesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingCatalogResult {
    private PageInfo pageInfo;
    private List<CatalogLesson> results;
}
