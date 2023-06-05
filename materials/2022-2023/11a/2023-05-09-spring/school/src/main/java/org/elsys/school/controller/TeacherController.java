package org.elsys.school.controller;

import lombok.RequiredArgsConstructor;
import org.elsys.school.controller.resources.TeacherResource;
import org.elsys.school.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TeacherResource teacherResource) {
        TeacherResource saved = teacherService.save(teacherResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/teachers/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TeacherResource teacherResource, @PathVariable long id) {
        return ResponseEntity.ok(teacherService.update(teacherResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        teacherService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
