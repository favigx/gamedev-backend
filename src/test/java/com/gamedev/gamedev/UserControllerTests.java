package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import com.gamedev.gamedev.controllers.UserController;
import com.gamedev.gamedev.models.User;
import com.gamedev.gamedev.services.UserService;

@SpringBootTest
public class UserControllerTests {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController(userService, passwordEncoder);
        ReflectionTestUtils.setField(
                userController, "jwtSecret",
                "40b174c5488db8db1b5f0bd69c9578956e1408a82aba54599a07b0091fdfbf7754fbe4abcdcf301d3567b558852b03029ab0d4241f8d651e91f2e66064bf9b1741a146149cebde6599c2347283d309e7e26fc78005a5d4b80fbb8f861ff8f03501329e269c1a9f65a1e5d3e0798d9a06e3dd6d9ab4c712f0f78e43fc42fa31d264ccebf5238e3c0c5241e1d0fdd80ddcd6479f9234efc775ca6fd2ebfd31ae85ffbc783ad6d0b31dc1badb1121ec241be41c2c46f424a9038152e5b9e286c4526f7ae980f130f4845e6742bee81f8b00c8aa3e0d2abc754671cb5625b2b5876f9f5340260b171440f7644beeb6b72a41dd3efb1784113db783cdaaa5a6b686a9f40f6a92270a26db977a7df6819267145bed426d9f7668a741da59930c39fdc85159e500056cc1308d97d694fd3b40939d900bdd007d7435f6cd0e56a2836ab42dcfa3d9e66bfa0eda36dcc783d66abf8196fb28c55ba95791717b48d2115ae833b8decede8e2d56d6350f2ad45e6591fef34de505616518f59efa40fe165a001a7d1218240f8708388f21a1ffaa4f5bd4fc149500351012b26c2635e3b0b329c24921870ccfbca8872cb1d9fcaa5b418aa316db450325785a6eea4fcb504411f0987db8a560da6d9b687d978596569c4dd8656fc3b6340c689079e77a7183d039af039c5ffb9255d8478361857a60858ee1c61afa2647f52e10f93bb3c34e59");
    }

    @Test
    public void addUser() {
        // Test för att se om en användare registreras.
        User user = new User("testId10", "Kalle10", "123456", 0);
        assertTrue(userController.addUser(user).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void login() {
        // Test för att se om en användare kan logga in och få en jwt-token.
        User user = new User("testId10", "Kalle10", "123456", 0);
        assertTrue(userController.login(user).getStatusCode().is2xxSuccessful());
    }
}