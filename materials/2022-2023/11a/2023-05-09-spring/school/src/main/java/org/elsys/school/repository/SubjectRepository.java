package org.elsys.school.repository;

import org.elsys.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> getSubjectsByName(String name);
}
