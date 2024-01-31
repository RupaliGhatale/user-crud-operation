package com.om.UserService.Services.impl;

import com.om.UserService.Model.User;
import com.om.UserService.Services.UserService;
import com.om.UserService.exceptions.ResourceNotFoundException;
import com.om.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // Generate unique user ID
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));
    }

    @Override
    public User delete(String userId) {
        User deletedUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found: " + userId));
        userRepository.deleteById(userId);
        return deletedUser;
    }
    @Override
    public User update(String userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found: " + userId));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAbout(updatedUser.getAbout());
        return userRepository.save(existingUser);
    }
    @Override
    public User partialUpdate(String userId, Map<String, Object> updates) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found: " + userId));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "name":
                    existingUser.setName((String) value);
                    break;
                case "email":
                    existingUser.setEmail((String) value);
                    break;
                case "about":
                    existingUser.setAbout((String) value);
                    break;

                default:
                    break;
            }
        }

        return userRepository.save(existingUser);
    }
}
