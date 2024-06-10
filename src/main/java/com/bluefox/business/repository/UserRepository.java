package com.bluefox.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluefox.business.model.User;

/**
 * Interface for accessing user data from the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
