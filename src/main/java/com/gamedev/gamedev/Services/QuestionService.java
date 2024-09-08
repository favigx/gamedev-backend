package com.gamedev.gamedev.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.gamedev.gamedev.models.Question;

@Service
public class QuestionService {

    private final MongoOperations mongoOperations;

    public QuestionService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public List<Question> getAllQuestions() {

        return mongoOperations.findAll(Question.class);

    }

    public List<Question> getRandomizedQuestions(int amount, List<Boolean> readyStates) {
        if (!readyStates.isEmpty() && readyStates.stream().allMatch((Boolean b) -> b == true)) {
            List<Question> allQuestions = getAllQuestions();
            Collections.shuffle(allQuestions);

            List<Question> requestedAmount = new ArrayList<>();

            for (int i = 0; i < amount; i++) {
                requestedAmount.add(allQuestions.get(i));
            }
            return requestedAmount;
        } else {
            return null;
        }
    }

    public Question getQuestionById(String questionId) {
        return mongoOperations.findById(questionId, Question.class);
    }
}
