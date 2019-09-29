package org.elsys.tuesky.api.trips;

public interface TripBuilder {

    TripBuilder then(TripUnit nextUnit);

    Trip end();
}
