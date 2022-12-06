package com.user.api.Utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import com.user.api.TestUtils.TestUtils;
import com.user.api.models.User;

public class DateUtilsTest {
    @Test
    void testValidateUserBirthDateShouldThrowsAnExceptionIfUserIsMinor() throws Exception {
        User user = TestUtils.generateMinorUser();
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            DateUtils.validateUserBirthDate(user);
        });

        String expectedMessage = "Minimum age is 18.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testValidateUserBirthDateShouldBeTrueIfUserIsMajor() throws Exception {
        User user = TestUtils.generateUser();
        assertTrue(DateUtils.validateUserBirthDate(user));
    }
}
