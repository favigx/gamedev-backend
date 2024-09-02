package com.gamedev.gamedev.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class Questions {
    @Id
    private String questionId;
    private String question;
    private String correctAnswer;

    public Questions(String questionId, String question, String correctAnswer) {
        this.questionId = questionId;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
}
