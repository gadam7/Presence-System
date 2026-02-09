package com.adamidis.learning.presencesystem.mapper;

import com.adamidis.learning.presencesystem.dto.ClassroomDto;
import com.adamidis.learning.presencesystem.dto.InstructorDto;
import com.adamidis.learning.presencesystem.dto.LessonDto;
import com.adamidis.learning.presencesystem.model.Classroom;
import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Lesson;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ClassroomMapper {

    public ClassroomDto mapToDto(Classroom classroom) {
        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setId(classroom.getId());
        classroomDto.setClassName(classroom.getClassName());
        classroomDto.setClassDate(classroom.getClassDate().toString());
        classroomDto.setClassTime(classroom.getClassTime().toString());

        // lesson mapping
        if (classroom.getLesson() != null) {
            Lesson lesson = classroom.getLesson();
            LessonDto lessonDto = new LessonDto();
            lessonDto.setId(lesson.getId());
            lessonDto.setTitle(lesson.getTitle());
            lessonDto.setDescription(lesson.getDescription());
            classroomDto.setLesson(lessonDto);
        }

        // instructor mapping
        if (classroom.getInstructor() != null) {
            Instructor instructor = classroom.getInstructor();
            InstructorDto instructorDto = new InstructorDto();
            instructorDto.setId(instructor.getId());
            instructorDto.setBio(instructor.getBio());
            classroomDto.setInstructor(instructorDto);
        }

        return classroomDto;
    }

    public Classroom toEntity(ClassroomDto dto) {
        Classroom classroom = new Classroom();
        classroom.setClassName(dto.getClassName());
        classroom.setClassDate(LocalDate.parse(dto.getClassDate()));
        classroom.setClassTime(LocalTime.parse(dto.getClassTime()));
        // lesson and instructor are handled in service
        return classroom;
    }
}
