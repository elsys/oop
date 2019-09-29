package org.elsys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    public void testAvarageGrade(){
        Student veso = new Student(1, "Veselin", "Rusinov");
        veso.addGrade(5.0);
        veso.addGrade(5.0);
        veso.addGrade(5.0);

        assertEquals(5.0, veso.avarageGrade());
    }
}
