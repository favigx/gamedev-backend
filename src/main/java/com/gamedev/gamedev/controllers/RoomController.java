package com.gamedev.gamedev.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamedev.gamedev.models.Room;
import com.gamedev.gamedev.services.RoomService;

@CrossOrigin(origins = "*")
@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room/{loggedInUsername}")
    public Room addRoom(@RequestBody Room room, @PathVariable String loggedInUsername) {
        return roomService.addRoom(room, loggedInUsername);
    }

    @GetMapping("/room/{roomId}")
    public Room getProjectById(@PathVariable String roomId) {
        return roomService.getRoomById(roomId);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/room/join/{roomId}/{userId}")
    public Room joinRoom(@PathVariable String roomId, @PathVariable String userId) {
        return roomService.joinRoom(roomId, userId);
    }

}
