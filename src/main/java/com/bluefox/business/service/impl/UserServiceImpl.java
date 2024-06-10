package com.bluefox.business.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluefox.business.model.User;
import com.bluefox.business.repository.UserRepository;
import com.bluefox.business.service.UserService;

/**
 * Implementation of UserService interface.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of all users.
     * 
     * @return List of all users
     */
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a list of all active users.
     * 
     * @return List of all active users
     */
    @Override
    public List<User> findAllActiveUsers() {
        return userRepository.findAll().stream()
                    .filter(user -> "ACTIVE".equals(user.getStatus()))
                    .toList();
    }

    /**
     * Retrieves a user by their ID.
     * 
     * @param id The ID of the user to retrieve
     * @return An Optional containing the user, if found, or empty if not found
     */
    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Saves a new user.
     * 
     * @param user The user to be saved
     * @return The saved user
     */
    @Override
    public User saveUser(User user) {
        user.setStatus("ACTIVE");
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     * 
     * @param id The ID of the user to update
     * @param updateUser The updated user object
     * @return An Optional containing the updated user if found, or empty if not found
     */
    @Override
    public Optional<User> updateUser(Long id, User updateUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setCpf(updateUser.getCpf());
            user.setRg(updateUser.getRg());
            user.setRole(updateUser.getRole());
            user.setStatus(updateUser.getStatus());
            return userRepository.save(user);
        });
    }

    /**
     * Disables an existing user.
     * 
     * @param id The ID of the user to disable
     * @return An Optional containing the disabled user, if found, or empty if not found
     */
    @Override
    public Optional<User> disableUser(Long id) {
        return userRepository.findById(id).map(user -> {
            user.setStatus("DISABLED");
            return userRepository.save(user);
        });
    }

    /**
     * Deletes a user by their ID.
     * 
     * @param id The ID of the user to delete
     */
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
}
