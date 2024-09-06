package com.gamedev.gamedev.models;

public class QuizRoom {

    private String roomId;
    private String roomName;
    private User userId;

    public QuizRoom(String roomId, String roomName, User userId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}
