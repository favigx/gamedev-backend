package com.gamedev.gamedev.models;

public class QuizResponse {

    private boolean correct;
    private int points;

    public QuizResponse() {
    }

    public QuizResponse(boolean correct, int points) {
        this.correct = correct;
        this.points = points;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
