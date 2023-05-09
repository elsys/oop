package org.elsys.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys.school.entity.Teacher;
import org.elsys.school.repository.TeacherRepository;
import org.elsys.school.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
