package com.adamidis.learning.presencesystem.dto;

public class ClassroomDto {

    private Integer id;
    private String className;
    private String classDate;
    private String classTime;
    private Integer instructorId;
    private Integer lessonId;
    private LessonDto lesson;
    private InstructorDto instructor;

    public ClassroomDto(Integer instructorId, Integer lessonId, Integer id, String className, String classDate, String classTime, LessonDto lesson, InstructorDto instructor) {
        this.instructorId = instructorId;
        this.lessonId = lessonId;
        this.id = id;
        this.className = className;
        this.classDate = classDate;
        this.classTime = classTime;
        this.lesson = lesson;
        this.instructor = instructor;
    }

    public  ClassroomDto() {

    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public LessonDto getLesson() {
        return lesson;
    }

    public void setLesson(LessonDto lesson) {
        this.lesson = lesson;
    }

    public InstructorDto getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDto instructor) {
        this.instructor = instructor;
    }
}