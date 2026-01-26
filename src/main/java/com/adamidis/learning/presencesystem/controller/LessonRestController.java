package com.adamidis.learning.presencesystem.controller;

import com.adamidis.learning.presencesystem.dto.LessonCreateDto;
import com.adamidis.learning.presencesystem.model.Lesson;
import com.adamidis.learning.presencesystem.service.LessonService;
import com.adamidis.learning.presencesystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class LessonRestController {

    private final LessonService lessonService;

    private final UserService userService;

    public LessonRestController(LessonService lessonService, UserService userService) {
        this.lessonService = lessonService;
        this.userService = userService;
    }

    @GetMapping("/lessons")
    public Set<Lesson> findAllLessons() {
        return lessonService.findAllLessons();
    }

    @GetMapping("/lessons/{id}")
    public Lesson findLessonById(@PathVariable Integer id) {
        Lesson tempLesson = lessonService.findById(id);
        return tempLesson;
    }

    @PostMapping("/lessons")
    public Lesson createLesson(@RequestBody LessonCreateDto lessonCreateDto) {
        return lessonService.save(
                new Lesson(
                        lessonCreateDto.getTitle(),
                        lessonCreateDto.getDescription()
                ),
                lessonCreateDto.getInstructorId()
        );
    }
}
