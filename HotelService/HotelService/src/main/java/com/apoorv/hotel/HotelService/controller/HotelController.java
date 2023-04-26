package com.apoorv.hotel.HotelService.controller;

import com.apoorv.hotel.HotelService.entity.Hotel;
import com.apoorv.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel)
    {
        Hotel hotel1=hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getsingleUser(@PathVariable String hotelId)
    {
        Hotel hotel=hotelService.get(hotelId);
        return ResponseEntity.ok(hotel);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getallUser()
    {
        List<Hotel> hotels=hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }

}
