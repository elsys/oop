package org.elsys.tuesky.api.trips;

import org.elsys.tuesky.api.planner.TripQuery;

import java.time.Duration;

public interface Trip {

    String getOrigin();

    String getDestination();

    Duration getDuration();

    Duration getLayoverDuration();

    int getFlightsCount();

    boolean matches(TripQuery query);
}
