package com.adamidis.learning.presencesystem.dto;

public class InstructorDto {

    private Integer id;
    private String bio;
    private LessonDto lessonDto;

    public InstructorDto(Integer id, String bio, LessonDto lessonDto) {
        this.id = id;
        this.bio = bio;
        this.lessonDto = lessonDto;
    }

    public InstructorDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LessonDto getLessonDto() {
        return lessonDto;
    }

    public void setLessonDto(LessonDto lessonDto) {
        this.lessonDto = lessonDto;
    }
}
