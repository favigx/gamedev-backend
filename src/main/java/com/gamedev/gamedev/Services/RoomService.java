package com.gamedev.gamedev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gamedev.gamedev.models.Room;
import com.gamedev.gamedev.models.User;

@Service
public class RoomService {

    private final MongoOperations mongoOperations;

    public RoomService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Room addRoom(Room room, String loggedInUsername) {

        room.setCreatedBy(loggedInUsername);

        Room savedRoom = mongoOperations.insert(room);

        Query query = new Query(Criteria.where("username").is(loggedInUsername));
        User user = mongoOperations.findOne(query, User.class);

        List<String> usernames = new ArrayList<>();
        usernames.add(user.getUsername());
        room.setParticipants(usernames);
        mongoOperations.save(room);

        return savedRoom;
    }

    public List<Room> getAllRooms() {
        return mongoOperations.findAll(Room.class);
    }

    public Room getRoomById(String roomId) {
        return mongoOperations.findById(roomId, Room.class);
    }

    public Room joinRoom(String roomId, String userId) {
        Room room = mongoOperations.findById(roomId, Room.class);
        if (room == null) {
            throw new IllegalArgumentException("Room not found with ID: " + roomId);
        }

        Query query = Query.query(Criteria.where("userId").is(userId));
        User user = mongoOperations.findOne(query, User.class);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        List<String> participants = room.getParticipants();
        if (participants == null) {
            participants = new ArrayList<>();
        }
        if (!participants.contains(user.getUsername())) {
            participants.add(user.getUsername());
            room.setParticipants(participants);

            mongoOperations.save(room);
        }

        return room;
    }
}
