package com.gamedev.gamedev.controllers;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.gamedev.gamedev.models.Question;
import com.gamedev.gamedev.services.QuestionService;

@Controller
public class StompController {

    private final QuestionService questionService;

    public StompController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @MessageMapping("/start-quiz")
    @SendTo("/topic/quiz")
    public List<Question> startQuiz(int ammount) {
        return questionService.getRandomizedQuestions(ammount);
    }

}
