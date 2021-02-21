package com.nrkt.locationservice.repository;

import com.nrkt.locationservice.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
