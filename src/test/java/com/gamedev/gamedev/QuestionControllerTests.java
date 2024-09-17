package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gamedev.gamedev.controllers.QuestionController;
import com.gamedev.gamedev.services.QuestionService;

@SpringBootTest
public class QuestionControllerTests {
    @Autowired
    private QuestionService questionService;
    private QuestionController questionController;

    @Test
    public void getRandomizedQuestions() {
        // Test för att kontrollera att antalet önskade frågor faktiskt returneras.
        questionController = new QuestionController(questionService);
        int amount = 5;
        assertEquals(5, questionController.getRandomizedQuestions(amount).size());
        amount = 7;
        assertEquals(7, questionController.getRandomizedQuestions(amount).size());
        amount = 10;
        assertEquals(10, questionController.getRandomizedQuestions(amount).size());
    }
}
