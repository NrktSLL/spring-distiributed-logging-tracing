package com.nrkt.userservice.bootstrap;

import com.nrkt.userservice.domain.User;
import com.nrkt.userservice.repository.UserRepository;
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

    UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.findAll().isEmpty()) {
            var testUser = User.builder().name("test").build();
            userRepository.save(testUser);
        }
    }
}
