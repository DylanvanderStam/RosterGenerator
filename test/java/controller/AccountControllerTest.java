package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {

    @Test
    void checkPassword() {
        assertFalse(AccountController.checkPassword("````", "````"));
        assertFalse(AccountController.checkPassword("Test 1", "Test 1"));
        assertFalse(AccountController.checkPassword("Test1", "Test2"));
        assertTrue(AccountController.checkPassword("Test1", "Test1"));
    }
}