package com.lesson.model;

import com.lesson.enums.DVPair;

import java.time.Instant;

public  interface Lesson {
    Long getLessonCode();
    String getLocale();
    int getDuration();
    String getFormat();
    String getTitle();
    String getCategory();
    String getDescription();
    String getLaunchPayload();
    boolean isMandatory();
    DVPair getRole();
    DVPair getStatus();
    Instant getAssignedAt();
}
