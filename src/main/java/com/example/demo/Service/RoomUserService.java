package com.example.demo.Service;

import com.example.demo.Model.Room;
import com.example.demo.Model.RoomUser;
import com.example.demo.dto.RoomUserDTO;
import com.example.demo.repository.RoomUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RoomUserService {
    @Autowired
    private RoomUserRepository roomUserRepository;

    @Autowired
    private RoomService roomService;

    public List<RoomUser> findAll() {
        return roomUserRepository.findAll();
    }

    public RoomUser findById(Long id) throws NoSuchElementException {
        return roomUserRepository.findById(id).get();
    }

    public String addNewRoomUser(RoomUserDTO dto) throws NoSuchElementException{
        Room room=roomService.findById(dto.getRoomId());
        RoomUser user=new RoomUser();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRoom(room);
        roomUserRepository.save(user);
        return "New user added successfully.";
    }
}
