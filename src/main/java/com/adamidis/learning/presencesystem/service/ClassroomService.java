package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.dto.ClassroomDto;

import java.util.Set;

public interface ClassroomService {
    Set<ClassroomDto> findAllClassrooms();

    ClassroomDto save(ClassroomDto classroomDto);
}
