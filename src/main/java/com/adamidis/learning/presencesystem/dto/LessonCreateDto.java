package com.adamidis.learning.presencesystem.dto;

public class LessonCreateDto {

    private String title;
    private String description;
    private Integer instructorId;

    public LessonCreateDto(String title, String description, Integer instructorId) {
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }
}
