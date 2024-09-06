package com.gamedev.gamedev.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
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
}