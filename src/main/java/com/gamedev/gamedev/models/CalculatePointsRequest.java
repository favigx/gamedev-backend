package com.gamedev.gamedev.models;

public class CalculatePointsRequest {
    private String questionId;
    private String answer;
    private String username;
    private Double timeToAnswer;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTimeToAnswer() {
        return timeToAnswer;
    }

    public void setTimeToAnswer(Double timeToAnswer) {
        this.timeToAnswer = timeToAnswer;
    }
}
