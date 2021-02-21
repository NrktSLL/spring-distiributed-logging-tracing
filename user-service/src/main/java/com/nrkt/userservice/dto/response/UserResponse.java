package com.nrkt.userservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponse implements Serializable {
    @NotNull
    Long id;
    @NotBlank
    @Schema(description = "User", example = "Nrkt", required = true)
    String name;
}
