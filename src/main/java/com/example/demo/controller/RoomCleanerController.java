package com.example.demo.controller;

import com.example.demo.Model.RoomCleaner;
import com.example.demo.Service.RoomCleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room-cleaner")
public class RoomCleanerController {
    @Autowired
    RoomCleanerService roomCleanerService;

    @GetMapping()
    public List<RoomCleaner> getAllRoomCleaners(){
        return roomCleanerService.findAll();
    }
}
