package org.elsys.school.service;

import org.elsys.school.controller.resources.TeacherResource;

import java.util.List;

public interface TeacherService {
    List<TeacherResource> findAll();

    TeacherResource getById(long teacherId);

    TeacherResource save(TeacherResource teacher);

    TeacherResource update(TeacherResource resource, long id);

    void delete(long teacherId);


}
