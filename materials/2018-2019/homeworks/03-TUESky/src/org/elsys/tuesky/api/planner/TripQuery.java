package org.elsys.tuesky.api.planner;

import org.elsys.tuesky.api.trips.Trip;

public interface TripQuery {

    boolean matches(Trip trip);

    TripQuery and(TripQuery query);

    TripQuery or(TripQuery query);

    TripQuery not();
}
