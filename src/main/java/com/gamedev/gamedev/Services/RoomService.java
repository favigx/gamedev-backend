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
}
