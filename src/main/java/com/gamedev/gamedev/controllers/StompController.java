package com.gamedev.gamedev.controllers;

import java.util.List;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

import com.gamedev.gamedev.models.AnswerChoice;
import com.gamedev.gamedev.models.CalculatePointsRequest;
import com.gamedev.gamedev.models.CalculatePointsResponse;
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

    public StompController(QuestionService questionService, RoomService roomService, StompService stompService) {
        this.questionService = questionService;
        this.roomService = roomService;
        this.stompService = stompService;
    }

    // @MessageMapping("/start-quiz")
    // @SendTo("/topic/quiz")
    // public List<Question> startQuiz(int ammount) {
    // return questionService.getRandomizedQuestions(ammount);
    // }

    @MessageMapping("/start-quiz/{roomId}")
    @SendTo("/topic/quiz/{roomId}")
    public List<Question> startQuiz(@DestinationVariable String roomId, @Payload int amount) {
        return questionService.getRandomizedQuestions(amount);
    }

    @MessageMapping("/answer-choice")
    @SendTo("/topic/answer-choice")
    public String answerChosen(AnswerChoice chosenAnswer) {
        return chosenAnswer.getUsername() + " Valde: " + chosenAnswer.getAnswer();
    }

    @MessageMapping("/has-answered")
    @SendTo("/topic/has-answered")
    public String hasAnswered(String username) {
        return username + " har svarat, öka takten!";
    }

    @MessageMapping("/getrooms")
    @SendTo("/topic/rooms")
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    @MessageMapping("/calculate-points")
    @SendTo("/topic/calculate-points")
    public CalculatePointsResponse calculatePoints(CalculatePointsRequest calculatePointsRequest) {
        return stompService.calculatePoints(calculatePointsRequest);

    }

    @MessageMapping("/room/{roomId}/joined-room-message")
    @SendTo("/topic/room/{roomId}/joined-room-message")
    public String joinedRoomMessage(@DestinationVariable String roomId, String username) {

        return username + " har gått med i rummet ";
    }

    @MessageMapping("/add-participant")
    @SendTo("/topic/add-participant")
    public String addParticipant(String participant) {
        return participant;
    }
}
