package com.nrkt.locationservice.bootstrap;

import com.nrkt.locationservice.domain.Location;
import com.nrkt.locationservice.enums.AddressType;
import com.nrkt.locationservice.repository.LocationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class DataLoader implements CommandLineRunner {

    LocationRepository locationRepository;

    @Override
    public void run(String... args) {
        if (locationRepository.findAll().isEmpty()) {
            var testLocation = Location.builder()
                    .addressType(AddressType.HOME)
                    .city("Ankara")
                    .build();

            locationRepository.save(testLocation);
        }
    }
}
