package com.gamedev.gamedev.models;

public class AnswerChoice {
    
    private String username;
    private String answer;
    
    public AnswerChoice(String username, String answer) {
        this.username = username;
        this.answer = answer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
}
