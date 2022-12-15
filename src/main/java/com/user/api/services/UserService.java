package com.user.api.services;

import org.springframework.stereotype.Service;

import com.user.api.models.User;
import com.user.api.repositories.UserRepository;

import javax.validation.Valid;

import static com.user.api.utils.DateUtils.validateUserBirthDate;

import java.util.Optional;

@Service(UserServiceInterface.BEAN_NAME)
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(@Valid User userToCreate) {
        validateUserBirthDate(userToCreate);

        return userRepository.save(userToCreate);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }
}
