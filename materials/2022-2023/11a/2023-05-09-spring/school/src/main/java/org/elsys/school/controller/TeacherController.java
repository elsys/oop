package org.elsys.school.controller;

import lombok.RequiredArgsConstructor;
import org.elsys.school.entity.Teacher;
import org.elsys.school.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public String findAll() {
        return teacherService.findAll().toString();
    }

    @GetMapping("/create")
    public String create() {
        Teacher t = new Teacher();
        t.setName("Teacher");
        t.setAge(10);

        return teacherService.save(t).toString();
    }
}
