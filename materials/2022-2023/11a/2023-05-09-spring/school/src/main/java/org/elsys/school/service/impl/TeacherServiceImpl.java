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

import static org.elsys.school.mapper.TeacherMapper.TEACHER_MAPPER;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubjectService subjectService;

    @Override
    public List<TeacherResource> findAll() {
        return TEACHER_MAPPER.toTeacherResources(teacherRepository.findAll());
    }

    @Override
    public TeacherResource getById(long teacherId) {
        return TEACHER_MAPPER.toTeacherResource(teacherRepository.getReferenceById(teacherId));
    }

    @Override
    public TeacherResource save(TeacherResource teacherResource) {
        Teacher teacher = TEACHER_MAPPER.fromTeacherResource(teacherResource);
        subjectService.getSubjectByName(teacher.getSubject().getName())
                .ifPresentOrElse(
                        teacher::setSubject,
                        () -> {
                            throw new EntityNotFoundException("");
                        }
                );
        return TEACHER_MAPPER.toTeacherResource(teacherRepository.save(teacher));
    }

    @Override
    public void delete(long teacherId) {
        teacherRepository.deleteById(teacherId);
    }


}
