package com.nrkt.locationservice.domain;

import com.nrkt.locationservice.enums.AddressType;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;
    @Column
    String street;
    @Column
    Integer postalCode;
    @Column
    @NotBlank
    String city;
    @Column
    @NotNull
    AddressType addressType;
}
