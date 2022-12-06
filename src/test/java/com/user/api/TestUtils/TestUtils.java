package com.user.api.TestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.user.api.models.Gender;
import com.user.api.models.User;

public class TestUtils {
    
    public static User generateUser() throws ParseException {
        String date = "04-12-1989";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = dateFormat.parse(date);
        User user = new User(
                1, "Jean", birthDate, "France", "xxx-xxx-xxx", Gender.MALE);
        return user;
    }

    public static User generateMinorUser() throws ParseException {
        String date = "04-12-2007";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = dateFormat.parse(date);
        User user = new User(
                1, "Jean", birthDate, "France", "xxx-xxx-xxx", Gender.MALE);
        return user;
    }
}
