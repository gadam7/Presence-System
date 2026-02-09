package com.adamidis.learning.presencesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "class_rooms")
@EntityListeners(AuditingEntityListener.class)
public class Classroom extends BaseEntity {

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "class_date", nullable = false)
    private LocalDate classDate;

    @Column(name = "class_time", nullable = false)
    private LocalTime classTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson; // which lesson is this class associated with

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor; // which instructor is teaching this class

    public Classroom() {

    }

    public Classroom(String className, LocalDate classDate, LocalTime classTime, Lesson lesson, Instructor instructor) {
        this.className = className;
        this.classDate = classDate;
        this.classTime = classTime;
        this.lesson = lesson;
        this.instructor = instructor;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    public LocalTime getClassTime() {
        return classTime;
    }

    public void setClassTime(LocalTime classTime) {
        this.classTime = classTime;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
