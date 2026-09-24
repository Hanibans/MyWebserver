package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void validatePasswordToShort() {
        UserService userService = new UserService();
        assertFalse(userService.validatePassword("1234"));
    }

    @Test
    void validatePasswordToLong() {
        UserService userService = new UserService();
        assertFalse(userService.validatePassword("12345678901234567890"));
    }

    /*
    assertFalse(userService.validatePassword(""));
    assertTrue(userService.validatePassword(""));
    assertEquals(false/true, userService.validatePassword(""));
     */
}