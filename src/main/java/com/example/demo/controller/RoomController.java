package com.example.demo.controller;

import com.example.demo.Model.Room;
import com.example.demo.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping()
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("/new")
    public String createRoom(@RequestBody Room room){
        roomService.createRoom(room);
        return "New room is added.";
    }

    @GetMapping("/cheapRooms")
    public List<Room> cheapRooms(){
        return roomService.cheapRooms();
    }

    @GetMapping("/dvokrevetne")
    public List<Room> dvokrevetneSobe(){
        return roomService.getDvokrevetneSobe();
    }

//    @GetMapping("/{type}")
//    public List<Room> findAllRoomsByType(@PathVariable("type") String type){
//        return roomService.findAllRoomsByType(type);
//    }

    // ZBOG ISTOG PATTERNA RUTA, METODA IZNAD ILI OVA ISPOD NE MOGU ISTOVREMENO BITI U FUNKCIJI (DOK NE NAUCIMO I TO RIJESIT HAHA)

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Room with requested id=" + id + " does not exist in our database.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") Long id, @RequestBody Room room) {
        try{
            roomService.update(id, room);
            return new ResponseEntity<>("Room with id=" + id + " is updated.", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Room with requested id=" + id + " does not exist in our database, so it cannot be updated.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        try{
            roomService.delete(id);
            return new ResponseEntity<>("Room with id=" + id + " is deleted.", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Room with requested id=" + id + " does not exist in our database, so it cannot be deleted.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cheaper-than-{price}")
    public List<Room> findAllRoomsCheaperThan(@PathVariable("price") int price){
        return roomService.findAllRoomsCheaperThan(price);
    }

    // RUTA ZA DEMONSTRACIJU BUG-A I TEHNIKA DEBAGOVANJA
    // BUG koji se desi ako nas room number nije isti kao kod PRVOG objekta koji se uzme iz baze (2) - dakle kroz petlju u servisu se UVIJEK prodje samo jednom
    // sout tehnika nas za unos bilo kojeg drugog room numbera vodi do linije nakon koje se odmah baci exception - tu je bug
    @GetMapping("/room-number-{rn}")
    public ResponseEntity<?> roomNumberEquals(@PathVariable("rn") short number) throws Exception {
        System.out.println("Linija 85");
        Room room=roomService.roomNumberEquals(number);
        // naredna linija se izvrsi samo ako je uneseni room number isti kao kod prvog elementa u bazi, dakle bug se desi u liniji iznad
        System.out.println("Linija 88");
        if(room==null)
            return new ResponseEntity<>("Room with requested room number=" + number + " does not exist in our database.", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
