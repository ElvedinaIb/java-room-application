package com.example.demo.repository;

import com.example.demo.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT room FROM Room room WHERE room.price < :price")
    List<Room> findAllRoomsCheaperThan(@Param("price") int price);

    @Query("SELECT room FROM Room room WHERE room.type LIKE %:type%")
    List<Room> findAllRoomsByType(@Param("type") String type);
}
