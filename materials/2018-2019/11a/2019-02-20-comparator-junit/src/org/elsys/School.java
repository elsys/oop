package org.elsys;

import java.util.*;

public class School {

    private String name;

    private List<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Map<String, List<Student>> getStudentsByClass() {
        return null;
    }

    public List<Student> getStudentsOrderedByGrade() {
        List<Student> ordered = new ArrayList<>(students);
        ordered.sort(new Comparator<Student>() {

            public int compare(Student o1, Student o2) {
//                if (o1.getAverageGrade() > o2.getAverageGrade()) {
//                    return 1;
//                } else if (o1.getAverageGrade() < o2.getAverageGrade()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
                return (int) Math.ceil(
                        o2.getAverageGrade() - o1.getAverageGrade());
            }
        });
        return ordered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) &&
                Objects.equals(students, school.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
