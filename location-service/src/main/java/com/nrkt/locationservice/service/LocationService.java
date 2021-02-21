package com.nrkt.locationservice.service;

import com.nrkt.locationservice.dto.request.LocationRequest;
import com.nrkt.locationservice.dto.response.LocationResponse;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {
    LocationResponse addLocation(LocationRequest locationRequest);

    void removeLocation(Long id);

    LocationResponse getLocation(Long id);

    List<LocationResponse> getLocations(Pageable pageable);
}
