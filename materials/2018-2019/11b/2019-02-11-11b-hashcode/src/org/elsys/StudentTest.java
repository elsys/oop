package org.elsys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testGetFirstName(){
        Student veselin2 =
                new Student(1, "Rusinov", "Veselin");
        assertEquals("Rsusinov", veselin2.getFirstName() );

    }
}
