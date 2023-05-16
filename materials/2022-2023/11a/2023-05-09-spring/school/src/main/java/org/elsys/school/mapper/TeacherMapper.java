package org.elsys.school.mapper;

import org.elsys.school.controller.resources.TeacherResource;
import org.elsys.school.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {

    TeacherMapper MAPPER = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "subject.name", source = "teacherResource.subject")
    Teacher fromTeacherResource(TeacherResource teacherResource);

    @Mapping(target = "subject", source = "teacher.subject.name")
    TeacherResource toTeacherResource(Teacher teacher);

    List<TeacherResource> toTeacherResources(List<Teacher> teachers);
}
