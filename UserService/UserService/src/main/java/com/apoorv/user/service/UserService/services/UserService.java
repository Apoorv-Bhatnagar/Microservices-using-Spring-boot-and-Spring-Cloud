package com.apoorv.user.service.UserService.services;

import com.apoorv.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getallUser();
    User getUser(String userId);
}
