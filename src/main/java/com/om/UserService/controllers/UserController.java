package com.om.UserService.controllers;

import com.om.UserService.Model.User;
import com.om.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;  // Corrected field name

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // all user get
    @GetMapping("/userlist")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
    @DeleteMapping("/{userId}")  // Corrected the path variable name
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        User deletedUser = userService.delete(userId);
        return ResponseEntity.ok(deletedUser);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
        User updatedUserData = userService.update(userId, updatedUser);
        return ResponseEntity.ok(updatedUserData);
    }
    @PatchMapping("/{userId}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable String userId, @RequestBody Map<String, Object> updates) {
        User updatedUserData = userService.partialUpdate(userId, updates);
        return ResponseEntity.ok(updatedUserData);
    }
}
