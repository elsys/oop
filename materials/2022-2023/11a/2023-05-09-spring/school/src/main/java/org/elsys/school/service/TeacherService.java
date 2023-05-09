package org.elsys.school.service;

import org.elsys.school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher save(Teacher teacher);
}
