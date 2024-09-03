package com.gamedev.gamedev.services;

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

}
