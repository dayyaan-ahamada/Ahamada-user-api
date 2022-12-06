package com.user.api.models;

import static javax.persistence.EnumType.STRING;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = User.TABLE_NAME)
public class User {
    public final static String TABLE_NAME = "users";
    public final static String API_PATH = "userId";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_USERNAME = "user_username";
    public static final String COLUMN_USER_BIRTH_DATE = "user_birth_date";
    public static final String COLUMN_USER_COUNTRY = "user_country";
    public static final String COLUMN_USER_PHONE = "user_phone";
    public static final String COLUMN_USER_GENDER = "user_gender";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_USER_ID)
    private int id;

    @Column(name = COLUMN_USER_USERNAME, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String username;

    @Column(name = COLUMN_USER_BIRTH_DATE, nullable = false)
    @NotNull
    private Date birthDate;

    @Column(name = COLUMN_USER_COUNTRY, nullable = false)
    @NotNull
    @NotEmpty
    @Pattern(regexp = "France")
    private String country;

    @Column(name = COLUMN_USER_PHONE)
    @Size(min = 4, max = 12)
    private String phone;

    @Column(name = COLUMN_USER_GENDER)
    @Enumerated(STRING)
    private Gender gender;
}
