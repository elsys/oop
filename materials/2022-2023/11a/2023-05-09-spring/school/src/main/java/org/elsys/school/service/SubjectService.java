package org.elsys.school.service;

import org.elsys.school.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Subject save(Subject subject);
}
