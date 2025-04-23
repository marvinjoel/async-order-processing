package com.OrderProcessorConsumer.service;

import com.OrderProcessorConsumer.model.User;
import com.OrderProcessorConsumer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final UserRepository userRepository;

    public User validateAndGetUser(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            log.error("User not found: {}", userId);
            throw new RuntimeException("User not found.");
        }
        return userOptional.get();
    }
}
