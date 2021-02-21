package com.nrkt.userservice.service;

import com.nrkt.userservice.domain.User;
import com.nrkt.userservice.dto.request.UserRequest;
import com.nrkt.userservice.dto.response.UserResponse;
import com.nrkt.userservice.exception.BadRequestException;
import com.nrkt.userservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        var newUser = User.builder().name(userRequest.getName()).build();
        var user = userRepository.save(newUser);
        return UserResponse.builder().name(user.getName()).id(user.getId()).build();
    }

    @Override
    public void removeUser(Long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("user not found!"));
        userRepository.delete(user);
    }

    @Override
    public UserResponse getUser(Long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("user not found!"));
        return UserResponse.builder().name(user.getName()).id(user.getId()).build();
    }

    @Override
    public List<UserResponse> getUsers(Pageable pageable) {
        List<UserResponse> userResponses = new ArrayList<>();
        var userList = userRepository.findAll(pageable).toList();
        for (User user : userList) {
            var userResponse =
                    UserResponse.builder().name(user.getName()).id(user.getId()).build();
            userResponses.add(userResponse);
        }
        return userResponses;
    }
}
