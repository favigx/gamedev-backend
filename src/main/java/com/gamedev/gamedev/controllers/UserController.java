package com.gamedev.gamedev.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamedev.gamedev.models.User;
import com.gamedev.gamedev.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${jwtSecret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpriationMs;

    @GetMapping()
    public String getRoot() {
        return "hej";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getQuestionById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User addedUser = userService.addUser(user);
            return ResponseEntity.ok(addedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Användarnamnet är upptaget, pröva något annat!");
        }
    }

    @PostMapping("/loginuser")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.getUserByUsername(user.getUsername());

        if (existingUser != null) {
            String encodedPassword = existingUser.getPassword();
            String incomingPassword = user.getPassword();

            if (passwordEncoder.matches(incomingPassword, encodedPassword)) {
                System.out.println("inloggad");
                @SuppressWarnings("deprecation")
                String token = Jwts.builder()
                        .setSubject(existingUser.getUsername())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + jwtExpriationMs))
                        .signWith(SignatureAlgorithm.HS512, jwtSecret)
                        .compact();
                return ResponseEntity.ok(token);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fel användarnamn eller lösenord");
    }
}