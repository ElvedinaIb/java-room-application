package com.example.demo.repository;

import com.example.demo.Model.RoomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomUserRepository extends JpaRepository<RoomUser,Long> {
}
