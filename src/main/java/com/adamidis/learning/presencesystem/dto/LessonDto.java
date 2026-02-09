package com.adamidis.learning.presencesystem.dto;

public class LessonDto {

    private Integer id;
    private String title;
    private String description;
    private InstructorDto instructorDto;

    public LessonDto(Integer id, String title, String description, InstructorDto instructorDto) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructorDto = instructorDto;
    }

    public LessonDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public InstructorDto getInstructorDto() {
        return instructorDto;
    }

    public void setInstructorDto(InstructorDto instructorDto) {
        this.instructorDto = instructorDto;
    }
}
