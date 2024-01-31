package com.om.UserService.Services;

import com.om.UserService.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    // crete user

    User saveUser(User user);
    // get all user
    List<User>getAllUser();
    // get single user of given userId
    User getUser(String userId);


    User delete(String userId);

    User update(String userId, User updatedUser);

    User partialUpdate(String userId, Map<String, Object> updates);
}
