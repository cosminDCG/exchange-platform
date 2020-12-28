package com.platform.exchange.service.impl;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.ExistingUserException;
import com.platform.exchange.exception.UserNotFoundException;
import com.platform.exchange.model.User;
import com.platform.exchange.repository.UserRepository;
import com.platform.exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User saveUser(User user) {
        boolean checkUser = userRepository.findByEmail(user.getEmail()).isPresent();
        if (checkUser) {
            throw new ExistingUserException(ErrorMessage.EXISTING_USER);
        }
        user.setId(UUID.randomUUID());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String uuid) {
        User user = userRepository.findById(UUID.fromString(uuid)).orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String uuid) {
        return userRepository.findById(UUID.fromString(uuid)).orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
    }
}