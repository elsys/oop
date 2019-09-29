package org.elsys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SchoolTest {

    private School school;
    private Student tosho;
    private Student emil;
    private Student vladi;
    private Student veselin;

    @BeforeAll
    public void setUp() {
        tosho = new Student("Tosho", "11A", 2);
        emil = new Student("Emil", "11A", 6);
        vladi = new Student("Vladi", "11B", 4.56);
        veselin = new Student("Veselin", "11A", 5.78);
        school = new School("TUES",
                Arrays.asList(tosho, emil, vladi, veselin));
    }

    @Test
    public void testGetStudentsOrderedByGrade() {
        tosho = new Student("Tosho", "11A", 2);
        emil = new Student("Emil", "11A", 6);
        vladi = new Student("Vladi", "11B", 4.56);
        veselin = new Student("Veselin", "11A", 5.78);
        List<Student> ordered = school.getStudentsOrderedByGrade();
        Assertions.assertEquals(0, ordered.indexOf(emil),
                "Emil is not at his place");
        Assertions.assertEquals(1, ordered.indexOf(veselin),
                "Veselin is not at his place");
        Assertions.assertEquals(2, ordered.indexOf(vladi),
                "Vladi is not at his place");
        Assertions.assertEquals(3, ordered.indexOf(tosho),
                "Tosho is not at his place");
    }

    @Test
    public void getStudentsByClass() {
        Map<String, List<Student>> studentsByClass = school.getStudentsByClass();
        Assertions.assertTrue(studentsByClass.get("11A").containsAll(
                Arrays.asList(tosho, emil, veselin)));
        Assertions.assertTrue(studentsByClass.get("11B").contains(vladi));
    }
}
