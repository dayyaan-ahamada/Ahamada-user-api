package com.user.api.utils;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.web.server.ResponseStatusException;

import com.user.api.models.User;

public class DateUtils {
    public static boolean validateUserBirthDate(User userToCreate) {
        LocalDate parsedDate = userToCreate.getBirthDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        if (parsedDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new ResponseStatusException(BAD_REQUEST, "Minimum age is 18.");
        }
        return true;
    }
}
