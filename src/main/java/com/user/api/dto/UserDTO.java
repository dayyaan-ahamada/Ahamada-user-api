package com.user.api.dto;

import java.util.Date;

import com.user.api.models.Gender;

import lombok.Data;

@Data
public class UserDTO {

    private int id;

    private String username;

    private Date birthDate;

    private String country;

    private String phone;

    private Gender gender;
}