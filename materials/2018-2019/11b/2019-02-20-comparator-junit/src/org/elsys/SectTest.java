package org.elsys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SectTest {

    @Test
    public void testGetMembersBySubscription() {
        Member mihael = new Member("Mihael", 5);
        Member boko = new Member("Boko", 20);
        Member acho = new Member("Acho", 2);
        Sect sect = new Sect(new Member("Stela Stefanova", 0.0),
                             "ELSYS",
                             Arrays.asList(mihael, boko, acho));
        List<Member> ordered = sect.getMembersOrderBySubscription();
        Assertions.assertEquals(1,
                                ordered.indexOf(mihael),
                                "Mihael is not at the correct place");
        Assertions.assertEquals(0,
                                ordered.indexOf(boko),
                                "Boko is not at the correct place");
        Assertions.assertEquals(2,
                                ordered.indexOf(acho),
                                "Acho is not at the correct place");
    }
}
