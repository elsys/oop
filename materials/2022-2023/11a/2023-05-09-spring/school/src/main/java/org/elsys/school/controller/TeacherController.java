package org.elsys.school.controller;

import lombok.RequiredArgsConstructor;
import org.elsys.school.controller.resources.TeacherResource;
import org.elsys.school.service.SubjectService;
import org.elsys.school.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final SubjectService subjectService;

    @GetMapping
    public String findAll() {
        return teacherService.findAll().toString();
    }

    @GetMapping("/create")
    public String create() {

        TeacherResource t = new TeacherResource();
        t.setName("Teacher");
        t.setAge(10);
        t.setSubject("asdasd");

        return teacherService.save(t).toString();
    }
}
