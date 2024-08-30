package com.example.demo.controller;

import com.example.demo.Service.RoomCleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-cleaner")
public class RoomCleanerController {
    @Autowired
    RoomCleanerService roomCleanerService;
}
