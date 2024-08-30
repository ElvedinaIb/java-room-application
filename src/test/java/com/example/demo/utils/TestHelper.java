package com.example.demo.utils;

import com.example.demo.Model.Room;

public class TestHelper {
    public static Room createNewRoom(){
     Room room=new Room();
     room.setRoomNumber((short) 50);
     room.setType("luksuzni apartman");
     room.setPrice(700);
     return room;
    }
}
