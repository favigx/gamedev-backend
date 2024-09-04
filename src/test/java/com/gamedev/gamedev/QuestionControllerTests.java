package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gamedev.gamedev.Services.QuestionService;
import com.gamedev.gamedev.controllers.QuestionController;

@SpringBootTest
public class QuestionControllerTests {
    @Autowired
    private QuestionService questionService;
    private QuestionController questionController;

    @Test
    public void getRandomizedQuestions() {
        // Test för att kontrollera om antalet önskade frågor faktiskt returneras.
        questionController = new QuestionController(questionService);
        int amount = 0;
        assertEquals(questionController.getRandomizedQuestions(amount).size(), amount);
    }
}
