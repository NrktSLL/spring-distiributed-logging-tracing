package com.nrkt.userservice.controller;

import com.nrkt.userservice.dto.request.UserRequest;
import com.nrkt.userservice.dto.response.UserResponse;

import com.nrkt.userservice.service.UserService;

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
@RequestMapping(value = "/v1/users", produces = {"application/json"})
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "users", description = "User Service")
public class UserController {

    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All User")
    public List<UserResponse> getUsers(@Parameter(hidden = true) @ParameterObject final Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a User")
    public UserResponse createUser(@NotNull @RequestBody @Valid UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a User")
    public UserResponse getUser(@PathVariable @NotNull Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove a User")
    public void deleteEmployee(@PathVariable @NotNull Long id) {
        userService.removeUser(id);
    }
}
