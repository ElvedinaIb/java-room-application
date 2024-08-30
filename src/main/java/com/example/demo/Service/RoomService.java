package com.example.demo.Service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.demo.Model.Room;
import com.example.demo.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String createRoom(Room room){
        roomRepository.save(room);
        return "New room is added.";
    }

    public List<Room> cheapRooms(){
        List<Room> allRooms=roomRepository.findAll();
        List<Room> cheapRooms=new ArrayList<>();
        for (Room room : allRooms){
            if (room.getPrice()<=200)
                cheapRooms.add(room);
        }
        return cheapRooms;
    }

    public List<Room> getDvokrevetneSobe(){
        List<Room> allRooms=roomRepository.findAll();
        List<Room> dvokrevetne=new ArrayList<>();
        for (Room room : allRooms){
            if (room.getType().contains("dvokrevetna"))
                dvokrevetne.add(room);
        }
        return dvokrevetne;
    }

    public Room findById(Long id) {
        Optional<Room> optionalRoom=roomRepository.findById(id);
        return optionalRoom.get();
    }

    public Room update(Long id, Room room) {
        roomRepository.findById(id).get();
        room.setId(id);
        return roomRepository.save(room);
    }

    public Room delete(Long id) {
        Room room=roomRepository.findById(id).get();
        roomRepository.deleteById(id);
        return room;
    }

    public List<Room> findAllRoomsCheaperThan(int price){
        return roomRepository.findAllRoomsCheaperThan(price);
    }

    public List<Room> findAllRoomsByType(String type){
        return roomRepository.findAllRoomsByType(type);
    }

    // BUG

    public Room roomNumberEquals(short number) throws Exception {
        System.out.println("Linija 79");
        List<Room> allRooms=roomRepository.findAll();
        System.out.println("Linija 81");
        for (Room room:allRooms)
            // ovdje vidimo koji je room number sobe uzete iz baze, pa mozemo zakljuciti koji ce se dio uslova izvrsiti
            if (room.getRoomNumber()==number) {
                System.out.println("Linija 85");
                return room;
            }
            else{
                System.out.println("Linija 89");
                throw new Exception("JA SAM BUG I TU SAM DA PRAVIM PROBLEM HEHE");
            }
        System.out.println("Linija 92");
        return null;
    }
}
