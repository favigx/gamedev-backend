package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gamedev.gamedev.Services.UserService;
import com.gamedev.gamedev.controllers.UserController;
import com.gamedev.gamedev.models.User;

@SpringBootTest
public class UserControllerTests {
    @Autowired
    private UserService userService;
    @Mock
    private PasswordEncoder passwordEncoder;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController(userService, passwordEncoder);
    }

    @Test
    public void addUser() {
        // Test för att se om en användare registreras.
        User user = new User("testId10", "Kalle10", "123456");
        assertTrue(userController.addUser(user).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void login() {
        // Test för att se om en användare kan logga in och få en jwt-token.
        User user = new User("testId10", "Kalle10", "123456");
        assertTrue(userController.login(user).getStatusCode().is2xxSuccessful());
    }
}
