package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.Flight;
import org.elsys.tuesky.impl.Factory;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {

    @Test
    public void test() {
        Flight flight = Factory.createFlight("Sofia", "Barcelona", Duration.ofHours(3));
        assertEquals(Duration.ofHours(3), flight.getDuration());
        assertEquals("Sofia", flight.getOrigin());
        assertEquals("Barcelona", flight.getDestination());
    }
}
