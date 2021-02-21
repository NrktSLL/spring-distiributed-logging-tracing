package com.nrkt.locationservice.controller;

import com.nrkt.locationservice.dto.request.LocationRequest;
import com.nrkt.locationservice.dto.response.LocationResponse;
import com.nrkt.locationservice.enums.AddressType;
import com.nrkt.locationservice.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/locations", produces = {"application/json"})
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "locations", description = "Location Service")
public class LocationController {

    LocationService locationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Location")
    public List<LocationResponse> getUsers(@Parameter(hidden = true) @ParameterObject final Pageable pageable) {
        return locationService.getLocations(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a Location")
    public LocationResponse createLocation(
            @NotNull @RequestBody @Valid LocationRequest locationRequest,
            @Valid @RequestParam AddressType addressType) {
        locationRequest.setAddressType(addressType);

        return locationService.addLocation(locationRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Location")
    public LocationResponse getUser(@PathVariable @NotNull Long id) {
        return locationService.getLocation(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove a Location")
    public void deleteEmployee(@PathVariable @NotNull Long id) {
        locationService.removeLocation(id);
    }
}
