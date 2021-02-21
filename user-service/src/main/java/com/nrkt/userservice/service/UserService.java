package com.nrkt.userservice.service;

import com.nrkt.userservice.dto.request.UserRequest;
import com.nrkt.userservice.dto.response.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);

    void removeUser(Long id);

    UserResponse getUser(Long id);

    List<UserResponse> getUsers(Pageable pageable);
}
