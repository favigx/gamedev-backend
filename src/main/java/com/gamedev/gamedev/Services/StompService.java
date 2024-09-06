package com.gamedev.gamedev.services;

import org.springframework.stereotype.Service;

import com.gamedev.gamedev.controllers.QuestionController;
import com.gamedev.gamedev.models.CalculatePointsRequest;
import com.gamedev.gamedev.models.Question;

@Service
public class StompService {

    private QuestionController questionController;
    

    public StompService(QuestionController questionController) {
        this.questionController = questionController;
    }


    public Integer calculatePoints(CalculatePointsRequest calculatePointsRequest) {

        int score = 0;

        Question question = questionController.getQuestionById(calculatePointsRequest.getQuestionId());

        if (question.getCorrectAnswer().equals(calculatePointsRequest.getAnswer())) {
            double secondsLeft = 15 - calculatePointsRequest.getTimeToAnswer();
            score = (int) (secondsLeft * 10);
        }

        return score;

    }
    
}
