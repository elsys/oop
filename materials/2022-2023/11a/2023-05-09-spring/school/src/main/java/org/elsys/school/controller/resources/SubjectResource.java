package org.elsys.school.controller.resources;

import lombok.Data;

import java.util.List;

@Data
public class SubjectResource {
    private int id;
    private String name;
    private List<TeacherResource> teachers;
}
