package com.example.demo.service;

import com.example.demo.Model.Room;
import com.example.demo.Service.RoomService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.demo.utils.TestHelper.createNewRoom;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;

    @Test
    public void getAllRoomsTest(){
        // act
        List<Room> allRooms=roomService.getAllRooms();
        // assert
        assertEquals(8, allRooms.size());
//        assertFalse(allRooms.isEmpty());
    }

    @Test
    public void createRoomTest(){
        String string=roomService.createRoom(createNewRoom());
        assertEquals("New room is added.", string);
    }

    @Test
    public void cheapRoomsTest(){
        roomService.createRoom(createNewRoom());
        List<Room> cheapRooms=roomService.cheapRooms();
//        assertTrue(cheapRooms.isEmpty());
        assertEquals(2, cheapRooms.size());
    }

    @Test
    public void getDvokrevetneSobeTest(){
        List<Room> roomsToReturn=roomService.getDvokrevetneSobe();
        assertTrue(roomsToReturn.size()==3);
    }

    @Test
    public void findByIdTest(){
        Room room=createNewRoom();
        roomService.createRoom(room);
        Room returnedRoom=roomService.findById(room.getId());
        assertEquals((short) 50, returnedRoom.getRoomNumber());
    }

    @Test
    public void updateTest(){
        Room room=createNewRoom();
        Room updatedRoom=roomService.update(2L, room);
        assertEquals("luksuzni apartman", updatedRoom.getType());
    }

    @Test
    public void deleteTest(){
        Room room=createNewRoom();
        roomService.createRoom(room);
        Room deletedRoom=roomService.delete(room.getId());
        assertTrue(deletedRoom.getPrice()==700);
    }

    @Test
    public void findAllRoomsCheaperThanTest(){
        List<Room> roomsToReturn=roomService.findAllRoomsCheaperThan(500);
        assertEquals(7, roomsToReturn.size());
    }

    @Test
    public void findAllRoomsByTypeTest(){
        roomService.createRoom(createNewRoom());
        List<Room> roomsToReturn=roomService.findAllRoomsByType("apartman");
        assertTrue(roomsToReturn.size()==4);
    }
}
