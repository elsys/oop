package org.elsys.school.service;

import org.elsys.school.controller.resources.TeacherResource;

import java.util.List;

public interface TeacherService {
    List<TeacherResource> findAll();

    TeacherResource getById(long teacherId);

    TeacherResource save(TeacherResource teacher);

    void delete(long teacherId);


}
