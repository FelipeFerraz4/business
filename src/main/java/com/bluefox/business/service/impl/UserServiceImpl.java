package com.bluefox.business.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluefox.business.model.User;
import com.bluefox.business.repository.UserRepository;
import com.bluefox.business.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllActiveUsers() {
        return userRepository.findAll().stream()
                    .filter(user -> "ACTIVE".equals(user.getStatus()))
                    .toList();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        user.setStatus("ACTIVE");
        return userRepository.save(user);
    }

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

    @Override
    public Optional<User> disableUser(Long id) {
        return userRepository.findById(id).map(user -> {
            user.setStatus("DISABLED");
            return userRepository.save(user);
        });
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
}
