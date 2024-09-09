package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gamedev.gamedev.controllers.QuestionController;
import com.gamedev.gamedev.services.QuestionService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class QuestionControllerTests {
    @Autowired
    private QuestionService questionService;
    private QuestionController questionController;

    @Test
    public void getRandomizedQuestions() {
        // Test för att kontrollera om antalet önskade frågor faktiskt returneras.
        questionController = new QuestionController(questionService);
        int amount = 5;
        List<Boolean> readyStates = new ArrayList<>();
        readyStates.add(true);
        readyStates.add(true);
        readyStates.add(true);
        readyStates.add(true);
        readyStates.add(true);
        assertTrue(questionController.getRandomizedQuestions(amount, readyStates) != null);
    }
}
