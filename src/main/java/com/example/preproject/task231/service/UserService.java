package com.example.preproject.task231.service;

import com.example.preproject.task231.model.User;
import com.example.preproject.task231.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User updateUser(Optional<Long> id) {
        if (id.isPresent()) {
            return findUser(id.get());
        } else {
            return new User();
        }
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
