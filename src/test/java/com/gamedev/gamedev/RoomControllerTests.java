package com.gamedev.gamedev;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gamedev.gamedev.controllers.RoomController;
import com.gamedev.gamedev.models.Room;
import com.gamedev.gamedev.services.RoomService;

@SpringBootTest
public class RoomControllerTests {
    @Autowired
    private RoomService roomService;
    private RoomController roomController;

    @Test
    public void addRoomTest() {
        // Test för att se om det går att lägga till ett rum.
        roomController = new RoomController(roomService);
        Room room1 = new Room("testId1", "Testrum1", null, null);
        Room room2 = new Room("testId2", "Testrum1", null, null);
        Room room3 = new Room("testId3", "", null, null);
        assertTrue(roomController.addRoom(room1, "Kalle1") != null);
        assertTrue(roomController.addRoom(room2, "Kalle2") != null);
        assertTrue(roomController.addRoom(room3, "Kalle3") != null);
    }
}