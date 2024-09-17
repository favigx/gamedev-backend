package com.gamedev.gamedev.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gamedev.gamedev.models.Question;
import com.gamedev.gamedev.services.QuestionService;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {

    private QuestionService questionsService;

    public QuestionController(QuestionService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("/question/{questionId}")
    public Question getQuestionById(@PathVariable String questionId) {
        return questionsService.getQuestionById(questionId);
    }

    @GetMapping("/questions/randomize/{amount}")
    public List<Question> getRandomizedQuestions(@PathVariable int amount) {
        return questionsService.getRandomizedQuestions(amount);
    }
}
