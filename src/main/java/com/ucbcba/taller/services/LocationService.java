package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Location;

/**
 * Created by Jp on 25/04/2017.
 */
public interface LocationService
{
    Iterable<Location> listAllLocation();

    Location getLocationById(Integer id);

    Location saveLocation(Location location);

    void deleteLocation(Integer id);
}
