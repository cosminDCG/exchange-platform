package com.platform.exchange.service.impl;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.UserNotFoundException;
import com.platform.exchange.model.User;
import com.platform.exchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), emptyList());
    }
}
