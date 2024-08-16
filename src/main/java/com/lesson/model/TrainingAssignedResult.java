package com.lesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingAssignedResult {
    private PageInfo pageInfo;
    private List<AssignedLesson> results;
}
