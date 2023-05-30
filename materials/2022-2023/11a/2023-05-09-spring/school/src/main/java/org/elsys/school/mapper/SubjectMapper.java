package org.elsys.school.mapper;

import org.elsys.school.controller.resources.SubjectResource;
import org.elsys.school.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = TeacherMapper.class)
public interface SubjectMapper {
    SubjectMapper SUBJECT_MAPPER = Mappers.getMapper(SubjectMapper.class);

    Subject fromSubjectResource(SubjectResource resource);

    SubjectResource toSubjectResource(Subject subject);

    List<SubjectResource> toSubjectResources(List<Subject> subjects);
}
