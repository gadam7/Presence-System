package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.dto.ClassroomDto;
import com.adamidis.learning.presencesystem.mapper.ClassroomMapper;
import com.adamidis.learning.presencesystem.model.Classroom;
import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Lesson;
import com.adamidis.learning.presencesystem.repository.ClassroomRepository;
import com.adamidis.learning.presencesystem.repository.InstructorRepository;
import com.adamidis.learning.presencesystem.repository.LessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final LessonsRepository lessonsRepository;
    private final InstructorRepository instructorRepository;
    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository,
                                LessonsRepository lessonsRepository,
                                InstructorRepository instructorRepository,
                                ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.lessonsRepository = lessonsRepository;
        this.instructorRepository = instructorRepository;
        this.classroomMapper = classroomMapper;
    }

    @Override
    public Set<ClassroomDto> findAllClassrooms() {
        return classroomRepository.findAll()
                .stream()
                .map(classroomMapper::mapToDto)
                .collect(toSet());
    }

    @Override
    public ClassroomDto save(ClassroomDto classroomDto) {
        Instructor creatorInstructor = instructorRepository
                .findById(classroomDto.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Did not find instructor -" +
                        classroomDto.getInstructorId()));

        Lesson tempLesson = lessonsRepository.findById(classroomDto.getLessonId())
                .orElseThrow(() -> new RuntimeException("Did not find lesson id - " +
                        classroomDto.getLessonId()));

        Classroom entity = classroomMapper.toEntity(classroomDto);
        entity.setInstructor(creatorInstructor);
        entity.setLesson(tempLesson);

        Classroom entitySaved = classroomRepository.save(entity);

        return classroomMapper.mapToDto(entitySaved);
    }
}
