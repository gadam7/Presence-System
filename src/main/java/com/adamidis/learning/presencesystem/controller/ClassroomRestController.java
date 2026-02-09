package com.adamidis.learning.presencesystem.controller;

import com.adamidis.learning.presencesystem.dto.ClassroomDto;
import com.adamidis.learning.presencesystem.service.ClassroomService;
import com.adamidis.learning.presencesystem.service.LessonService;
import com.adamidis.learning.presencesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ClassroomRestController {

    private ClassroomService classroomService;
    private LessonService lessonService;
    private UserService userService;

    @Autowired
    public ClassroomRestController(ClassroomService classroomService, LessonService lessonService, UserService userService) {
        this.classroomService = classroomService;
        this.lessonService = lessonService;
        this.userService = userService;
    }

    @GetMapping("/classrooms")
    public Set<ClassroomDto> findAllClassrooms() {
        return classroomService.findAllClassrooms();
    }

    @PostMapping("/classrooms")
    public ClassroomDto createClassroom(@RequestBody ClassroomDto classroomDto) {
        return classroomService.save(classroomDto);
    }
}
