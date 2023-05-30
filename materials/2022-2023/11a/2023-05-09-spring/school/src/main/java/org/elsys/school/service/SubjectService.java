package org.elsys.school.service;

import org.elsys.school.controller.resources.SubjectResource;
import org.elsys.school.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<SubjectResource> findAll();

    SubjectResource getById(long id);

    SubjectResource save(SubjectResource subject);

    Optional<Subject> getSubjectByName(String name);

    void delete(long id);


}
