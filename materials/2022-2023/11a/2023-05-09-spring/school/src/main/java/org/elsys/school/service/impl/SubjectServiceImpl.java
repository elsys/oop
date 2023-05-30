package org.elsys.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys.school.controller.resources.SubjectResource;
import org.elsys.school.entity.Subject;
import org.elsys.school.entity.Teacher;
import org.elsys.school.repository.SubjectRepository;
import org.elsys.school.repository.TeacherRepository;
import org.elsys.school.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.elsys.school.mapper.SubjectMapper.SUBJECT_MAPPER;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<SubjectResource> findAll() {
        return SUBJECT_MAPPER.toSubjectResources(subjectRepository.findAll());
    }

    @Override
    public SubjectResource getById(long id) {
        return SUBJECT_MAPPER.toSubjectResource(subjectRepository.getReferenceById(id));
    }

    @Override
    public SubjectResource save(SubjectResource resource) {
        Subject subject = SUBJECT_MAPPER.fromSubjectResource(resource);
        subject.setTeachers(null);

        return SUBJECT_MAPPER.toSubjectResource(subjectRepository.save(subject));
    }

    @Override
    public SubjectResource update(SubjectResource resource, long id) {
        Subject toUpdate = subjectRepository.getReferenceById(id);
        toUpdate.setName(resource.getName());

        return SUBJECT_MAPPER.toSubjectResource(subjectRepository.save(toUpdate));
    }

    @Override
    public Optional<Subject> getSubjectByName(String name) {
        return subjectRepository.getSubjectsByName(name);
    }

    @Override
    public void delete(long id) {
        teacherRepository.findAllBySubject_Id(id).forEach(this::removeSubject);
        subjectRepository.deleteById(id);
    }

    private void removeSubject(Teacher teacher) {
        teacher.setSubject(null);
        teacherRepository.save(teacher);
    }
}
