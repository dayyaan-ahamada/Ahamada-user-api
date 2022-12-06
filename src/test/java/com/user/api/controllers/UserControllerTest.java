package com.user.api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.api.TestUtils.TestUtils;
import com.user.api.models.User;
import com.user.api.repositories.UserRepository;
import com.user.api.services.UserService;

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();

        user = TestUtils.generateUser();
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        when(userRepository.findById(any())).thenReturn(Optional.of(user));

        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    void testHttpRequestShouldReturnBadRequest() throws Exception {
        mockMvc.perform(post("/user"))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testHttpRequestShouldReturnUnsopportedMediaType() throws Exception {
        mockMvc.perform(post("/user")
                .contentType("application/text"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void testCreateUserShouldBeOk() throws Exception {
        mockMvc.perform(post("/user")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetUserShouldBeOk() throws Exception {
        mockMvc.perform(get("/user/{userId}", 1)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.birthDate").value(user.getBirthDate()))
                .andExpect(jsonPath("$.country").value(user.getCountry()))
                .andExpect(jsonPath("$.phone").value(user.getPhone()))
                .andExpect(jsonPath("$.gender").value(user.getGender().toString()));
    }
}