package com.example.demo.Service;

import com.example.demo.repository.RoomCleanerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomCleanerService {
    @Autowired
    private RoomCleanerRepository roomCleanerRepository;
}
