import org.elsys.students.SchoolClass;
import org.elsys.students.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ivan", 10, new HashMap<>(){{
            put("TP", 6); // TP
            put("MAT", 6); // Matematika
            put("BEL", 4); // BEL
            put("IST", 2); // Istoria
        }});

        Student s2 = new Student("Petar", 15, new HashMap<>(){{
            put("TP", 3); // TP
            put("MAT", 1); // Matematika
            put("BEL", 1); // BEL
            put("IST", 4); // Istoria
        }});

        SchoolClass sc = new SchoolClass(new ArrayList(){{
            add(s1);
            add(s2);
        }});

        List<String> homework = new LinkedList<>(){{
            add("BEL");
            add("BEL");
            add("BEL");
            add("IST");
            add("TP");
            add("IST");
        }};

        try {
            // Wait a bit to make sure all students are running.
            Thread.sleep(500);
            sc.assignHomework(homework, 3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
