package org.elsys_bg;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private int age;
    private Gender gender;
}
