package com.user.api.services;

import java.util.Optional;

import com.user.api.models.User;

public interface UserServiceInterface {
    String BEAN_NAME = "userService";

    User createUser(User userToCreate);

    Optional<User> getUser(int id);

}
