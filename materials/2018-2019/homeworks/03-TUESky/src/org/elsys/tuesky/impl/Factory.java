package org.elsys.tuesky.impl;

import org.elsys.tuesky.api.planner.Planner;
import org.elsys.tuesky.api.trips.Flight;
import org.elsys.tuesky.api.trips.Layover;
import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.api.trips.TripBuilder;

import java.time.Duration;
import java.util.List;

public class Factory {

    public static TripBuilder startTrip() {
        // TODO implement me!
        return null;
    }

    public static Flight createFlight(String from, String to, Duration duration) {
        // TODO implement me!
        return null;
    }

    public static Layover createLayover(Duration duration) {
        // TODO implement me!
        return null;
    }

    public static Planner createPlanner(List<Trip> trips) {
        // TODO implement me!
        return null;
    }
}
