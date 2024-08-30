package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "roomNumber")
    private short roomNumber;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private int price;

    @ManyToOne
    private RoomCleaner roomCleaner;
}
