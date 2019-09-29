package org.elsys.tuesky.api.planner;

import org.elsys.tuesky.api.trips.Trip;

import java.util.List;

public interface Planner {

    List<Trip> search(TripQuery query);

    boolean anyMatch(TripQuery query);

    int count(TripQuery query);
}
