package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.TUESkyException;
import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.impl.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripTest {

    @Test
    public void testSingleFlightTrip() {
        Trip trip = Factory.startTrip()
                           .then(Factory.createFlight("Sofia", "Athens", Duration.ofHours(1)))
                           .end();
        assertEquals(Duration.ofHours(1), trip.getDuration());
        assertEquals(Duration.ofMillis(0), trip.getLayoverDuration());
        assertEquals("Sofia", trip.getOrigin());
        assertEquals("Athens", trip.getDestination());
        assertEquals(1, trip.getFlightsCount());
    }

    @Test
    public void testTwoFlightTrip() {
        Trip trip = Factory.startTrip()
                           .then(Factory.createFlight("Sofia", "Athens", Duration.ofHours(1)))
                           .then(Factory.createLayover(Duration.ofMinutes(90)))
                           .then(Factory.createFlight("Athens", "Xania", Duration.ofHours(1)))
                           .end();
        assertEquals(Duration.ofMinutes(210), trip.getDuration());
        assertEquals(Duration.ofMinutes(90), trip.getLayoverDuration());
        assertEquals("Sofia", trip.getOrigin());
        assertEquals("Xania", trip.getDestination());
        assertEquals(2, trip.getFlightsCount());
    }


    @Test
    public void testThreeFlightTrip() {
        Trip trip = Factory.startTrip()
                .then(Factory.createFlight("Sofia", "Eindhoven", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(90)))
                .then(Factory.createFlight("Eindhoven", "London", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(210)))
                .then(Factory.createFlight("London", "Havana", Duration.ofHours(10)))
                .end();
        assertEquals(Duration.ofHours(17), trip.getDuration());
        assertEquals(Duration.ofHours(5), trip.getLayoverDuration());
        assertEquals("Sofia", trip.getOrigin());
        assertEquals("Havana", trip.getDestination());
        assertEquals(3, trip.getFlightsCount());
    }

    @Test
    public void testNotMatchingTwoFlightTrip() {
        Assertions.assertThrows(
                TUESkyException.class,
                () -> Factory.startTrip()
                             .then(Factory.createFlight("Sofia", "Athens", Duration.ofHours(1)))
                             .then(Factory.createLayover(Duration.ofMinutes(90)))
                             .then(Factory.createFlight("Sofia", "Xania", Duration.ofHours(1)))
                             .end());
    }
}
