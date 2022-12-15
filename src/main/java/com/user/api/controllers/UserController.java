package com.user.api.controllers;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.user.api.dto.UserDTO;
import com.user.api.models.User;
import com.user.api.services.UserServiceInterface;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private final UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable(name = User.API_PATH) int userId) {
        
        User user = userService.getUser(userId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody @Valid UserDTO userToCreate) {

        User userRequest = modelMapper.map(userToCreate, User.class);

        User user = userService.createUser(userRequest);

        return modelMapper.map(user, UserDTO.class);
    }
}
