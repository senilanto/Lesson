package com.lesson.model;

import com.lesson.enums.DVPair;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssignedLesson implements Lesson{
    @Id
    private Long lessonCode;
    private String locale;
    private int duration;
    private String format;
    private String title;
    private String category;
    private String description;
    private String launchPayload;
    private boolean mandatory;
    private DVPair role;
    private DVPair status;
    private Instant assignedAt;
    private Instant dueAt;


    @Override
    public Long getLessonCode() {
        return lessonCode;
    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getLaunchPayload() {
        return launchPayload;
    }

    @Override
    public boolean isMandatory() {
        return mandatory;
    }

    @Override
    public DVPair getRole() {
        return role;
    }

    @Override
    public DVPair getStatus() {
        return status;
    }

    @Override
    public Instant getAssignedAt() {
        return assignedAt;
    }
    public Instant getDueAt() {
        return dueAt;
    }
}
