package com.nrkt.locationservice.error;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NonNull
@Builder
public class ApiError {
  String message;
  Date timestamp;
  Integer status;
  String error;
  String path;
}
