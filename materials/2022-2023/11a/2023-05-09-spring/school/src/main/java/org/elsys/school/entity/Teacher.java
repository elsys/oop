package org.elsys.school.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    @ManyToOne
    private Subject subject;
}
