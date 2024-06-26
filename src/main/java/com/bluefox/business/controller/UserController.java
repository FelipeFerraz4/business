package com.bluefox.business.controller;

import com.bluefox.business.model.User;
import com.bluefox.business.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * Returns a list of all users.
     * @return Returns all active users.
     */
    @Operation(summary = "Get all active users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucessful operation"),
    })
    @GetMapping
    public List<User> getAllActiveUsers() {
        return userService.findAllActiveUsers();
    }
    
    /**
     * Returns a list of all active users.
     * @return Returns all users.
     */
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucessful operation"),
    })
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * Finds a user by their ID.
     * @param id The user ID
     * @return Returns a user by ID.
     */
    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucessful operation"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create a new user
     * @return Creates a new user.
     */
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Sucessful operation"),
    })
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    /**
     * Updates an existing user.
     * @param id The user ID
     * @param newUser The user object with the new data
     * @return Updates an existing user.
     */
    @Operation(summary = "Update an existing user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucessful operation"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        Optional<User> updatedUser = userService.updateUser(id, newUser);
        return updatedUser.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * This method disables an existing user from the system
     * @param id The user ID
     * @return Disables a user
     */
    @Operation(summary = "Disable a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucessful operation"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}/disable")
    public ResponseEntity<User> disableUser(@PathVariable Long id) {
        Optional<User> disabledUser = userService.disableUser(id);
        return disabledUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * This method deletes an existing user from the system
     * @param id The user ID
     * @return Deletes a user
     */
    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Sucessful operation"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            userService.deleteUserById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
