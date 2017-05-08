package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Location;
import com.ucbcba.taller.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Jp on 25/04/2017.
 */
@Service
public class LocationServiceImpl implements LocationService
{
    private LocationRepository locationRepository;

    @Autowired
    @Qualifier(value = "locationRepository")
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Iterable<Location> listAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Integer id) {
        return locationRepository.findOne(id);
    }

    @Override
    public Location saveLocation(Location terminal) {
        return locationRepository.save(terminal);
    }

    @Override
    public void deleteLocation(Integer id) {
        locationRepository.delete(id);
    }
}
