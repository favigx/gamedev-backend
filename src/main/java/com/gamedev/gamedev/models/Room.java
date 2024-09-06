package com.gamedev.gamedev.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rooms")
public class Room {
    @Id
    private String roomId;
    private String roomName;
    private String createdBy;
    private List<String> participants;

    public Room(String roomId, String roomName, String createdBy, List<String> participants) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.createdBy = createdBy;
        this.participants = participants;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

}
