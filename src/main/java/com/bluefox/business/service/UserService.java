package com.bluefox.business.service;

import java.util.List;
import java.util.Optional;

import com.bluefox.business.model.User;

public interface UserService {
    
    List<User> findAllUsers();

    List<User> findAllActiveUsers();

    Optional<User> findUserById(Long id);

    User saveUser(User user);

    Optional<User> updateUser(Long id, User updateUser);

    Optional<User> disableUser(Long id);

    void deleteUserById(Long id);
}
