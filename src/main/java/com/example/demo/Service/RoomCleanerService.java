package com.example.demo.Service;

import com.example.demo.Model.RoomCleaner;
import com.example.demo.repository.RoomCleanerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomCleanerService {
    @Autowired
    private RoomCleanerRepository roomCleanerRepository;

    public List<RoomCleaner> findAll() {
        return roomCleanerRepository.findAll();
    }
}
