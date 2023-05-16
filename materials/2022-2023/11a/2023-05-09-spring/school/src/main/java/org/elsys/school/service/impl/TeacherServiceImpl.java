package org.elsys.school.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elsys.school.controller.resources.TeacherResource;
import org.elsys.school.entity.Teacher;
import org.elsys.school.repository.TeacherRepository;
import org.elsys.school.service.SubjectService;
import org.elsys.school.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elsys.school.mapper.TeacherMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubjectService subjectService;

    @Override
    public List<TeacherResource> findAll() {
        return MAPPER.toTeacherResources(teacherRepository.findAll());
    }

    @Override
    public Teacher save(TeacherResource teacherResource) {
        Teacher teacher = MAPPER.fromTeacherResource(teacherResource);
        subjectService.getSubjectByName(teacher.getSubject().getName())
                .ifPresentOrElse(
                        teacher::setSubject,
                        () -> {
                            throw new EntityNotFoundException("");
                        }
                );
        return teacherRepository.save(teacher);
    }
}
