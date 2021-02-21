package com.nrkt.locationservice.dto.request;

import com.nrkt.locationservice.enums.AddressType;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LocationRequest {
    @Schema(description = "Street", example = "Test Street", required = true)
    String street;
    @Schema(description = "Postal Code", example = "5580")
    Integer postalCode;
    @NotBlank
    @Schema(description = "City", example = "Ankara", required = true)
    String city;
    @NotNull
    @Schema(description = "Address Type", example = "Test Street", hidden = true)
    AddressType addressType;
}
