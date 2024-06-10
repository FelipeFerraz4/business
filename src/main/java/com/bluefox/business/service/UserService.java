package com.bluefox.business.service;

import java.util.List;
import java.util.Optional;

import com.bluefox.business.model.User;

public interface UserService {
    
    /**
     * Returns a list of all users.
     * @return List of all users
     */
    List<User> findAllUsers();

    /**
     * Returns a list of all active users.
     * @return List of all active users
     */
    List<User> findAllActiveUsers();

    /**
     * Finds a user by their ID.
     * @param id The user ID
     * @return An Optional containing the user, if found, or empty if not found
     */
    Optional<User> findUserById(Long id);

    /**
     * Saves a new user.
     * @param user The user to be saved
     * @return The saved user
     */
    User saveUser(User user);

    /**
     * Updates an existing user.
     * @param id O ID do usuário a ser atualizado
     * @param updateUser O objeto de usuário com os novos dados
     * @return An Optional containing the updated user if found, or empty if not found
     */
    Optional<User> updateUser(Long id, User updateUser);

    /**
     * Disables an existing user.
     * @param id The ID of the user to be disabled
     * @return An Optional containing the disabled user, if found, or empty if not found
     */
    Optional<User> disableUser(Long id);

    /**
     * Deletes an existing user.
     * @param id The ID of the user to be deleted
     */
    void deleteUserById(Long id);
}
