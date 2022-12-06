package com.user.api.controllers;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.user.api.models.User;
import com.user.api.services.UserServiceInterface;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable(name = User.API_PATH) int userId) {
        return userService.getUser(userId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @PostMapping
    public User createUser(@RequestBody @Valid User userToCreate) {
        return userService.createUser(userToCreate);
    }
}
