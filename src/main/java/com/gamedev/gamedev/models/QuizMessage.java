package com.gamedev.gamedev.models;

public class QuizMessage {

    private String questionId;
    private String selectedAnswer;
    private String userId;

    public QuizMessage() {
    }

    public QuizMessage(String questionId, String selectedAnswer, String userId) {
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
