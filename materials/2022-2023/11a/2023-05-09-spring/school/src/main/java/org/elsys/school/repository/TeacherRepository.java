package org.elsys.school.repository;

import org.elsys.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t where t.name like :name")
    List<Teacher> getAllTeacherByName(String name);

    List<Teacher> getTeachersByNameLikeAndAgeGreaterThan(String name, int age);
}
