package com.example.demo.repository;

import com.example.demo.Model.Room;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class RoomRepositoryTest {
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void findAllRoomsCheaperThanTest(){
        Room room=new Room();
        room.setRoomNumber((short) 31);
        room.setType("penthaus 2");
        room.setPrice(1000);
        roomRepository.save(room);

        List<Room> roomsToReturn=roomRepository.findAllRoomsCheaperThan(2000);

        assertFalse(roomsToReturn.isEmpty());
        assertEquals(9, roomsToReturn.size());
    }

    @Test
    public void findAllRoomsByTypeTest(){
        Room room=new Room();
        room.setRoomNumber((short) 50);
        room.setType("luksuzni apartman");
        room.setPrice(700);
        roomRepository.save(room);

        List<Room> roomsToReturn=roomRepository.findAllRoomsByType("apartman");

//        assertFalse(roomsToReturn.isEmpty());
        assertEquals(4, roomsToReturn.size());
    }
}
