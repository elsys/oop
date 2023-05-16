package org.elsys.school.service;

import org.elsys.school.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();

    Subject save(Subject subject);

    Optional<Subject> getSubjectByName(String name);
}
