package com.gamedev.gamedev.controllers;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.gamedev.gamedev.models.AnswerChoice;
import com.gamedev.gamedev.models.CalculatePointsRequest;
import com.gamedev.gamedev.models.Question;
import com.gamedev.gamedev.models.Room;
import com.gamedev.gamedev.services.QuestionService;

import com.gamedev.gamedev.services.RoomService;

import com.gamedev.gamedev.services.StompService;

@Controller
public class StompController {

    private final QuestionService questionService;

    private final RoomService roomService;

    private final StompService stompService;

    public StompController(QuestionService questionService, StompService stompService, RoomService roomService) {
        this.questionService = questionService;
        this.roomService = roomService;
        this.stompService = stompService;

    }

    @MessageMapping("/start-quiz")
    @SendTo("/topic/quiz")
    public List<Question> startQuiz(int ammount, List<Boolean> readyStates) {
        return questionService.getRandomizedQuestions(ammount, readyStates);
    }

    @MessageMapping("/answer-choice")
    @SendTo("/topic/answer-choice")
    public String answerChosen(AnswerChoice chosenAnswer) {
        return chosenAnswer.getUsername() + " Valde: " + chosenAnswer.getAnswer();
    }

    @MessageMapping("/getrooms")
    @SendTo("/topic/rooms")
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    @MessageMapping("/calculate-points")
    @SendTo("/topic/calculate-points")
    public Integer calculatePoints(CalculatePointsRequest calculatePointsRequest) {
        return stompService.calculatePoints(calculatePointsRequest);

    }

}
