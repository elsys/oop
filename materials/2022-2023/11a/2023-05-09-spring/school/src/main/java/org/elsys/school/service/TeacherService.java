package org.elsys.school.service;

import org.elsys.school.controller.resources.TeacherResource;
import org.elsys.school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherResource> findAll();

    Teacher save(TeacherResource teacher);
}
