package com.platform.exchange.service;

import com.platform.exchange.model.User;

public interface UserService {

    User saveUser(User user);

    void deleteUser(String uuid);

    User updateUser(User user);

    User getUser(String uuid);
}
