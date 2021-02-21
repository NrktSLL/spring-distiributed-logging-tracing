package com.nrkt.locationservice.service;

import com.nrkt.locationservice.domain.Location;
import com.nrkt.locationservice.dto.request.LocationRequest;
import com.nrkt.locationservice.dto.response.LocationResponse;

import com.nrkt.locationservice.exception.BadRequestException;
import com.nrkt.locationservice.repository.LocationRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    @Override
    public LocationResponse addLocation(LocationRequest locationRequest) {
        var newLocation = Location.builder()
                .addressType(locationRequest.getAddressType())
                .city(locationRequest.getCity())
                .postalCode(locationRequest.getPostalCode())
                .street(locationRequest.getStreet())
                .city(locationRequest.getCity())
                .build();

        var location = locationRepository.save(newLocation);
        return LocationResponse.builder()
                .addressType(location.getAddressType())
                .city(location.getCity())
                .postalCode(location.getPostalCode())
                .street(location.getStreet())
                .city(location.getCity())
                .build();
    }

    @Override
    public void removeLocation(Long id) {
        var user = locationRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("location not found!"));
        locationRepository.delete(user);
    }

    @Override
    public LocationResponse getLocation(Long id) {
        var location = locationRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("location not found!"));

        return LocationResponse.builder()
                .addressType(location.getAddressType())
                .city(location.getCity())
                .postalCode(location.getPostalCode())
                .street(location.getStreet())
                .city(location.getCity())
                .build();
    }

    @Override
    public List<LocationResponse> getLocations(Pageable pageable) {
        List<LocationResponse> locationResponses = new ArrayList<>();
        var locationList = locationRepository.findAll(pageable).toList();
        for (Location location : locationList) {
            var locationResponse =
                    LocationResponse.builder()
                            .addressType(location.getAddressType())
                            .city(location.getCity())
                            .postalCode(location.getPostalCode())
                            .street(location.getStreet())
                            .city(location.getCity())
                            .build();
            locationResponses.add(locationResponse);
        }
        return locationResponses;
    }
}
