package org.elsys.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys.school.entity.Subject;
import org.elsys.school.repository.SubjectRepository;
import org.elsys.school.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> getSubjectByName(String name) {
        return subjectRepository.getSubjectsByName(name);
    }
}
