package com.nrkt.userservice.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;
    @Column
    @NotBlank
    String name;
}
