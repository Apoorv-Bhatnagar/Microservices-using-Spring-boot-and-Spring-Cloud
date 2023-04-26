package com.apoorv.rating.RatingService.controller;

import com.apoorv.rating.RatingService.entity.Rating;
import com.apoorv.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> createUser(@RequestBody Rating rating)
    {
        Rating rating1=ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getratingbyUserId(@PathVariable String userId)
    {
        List<Rating> ratingbyuserid=ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingbyuserid);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getratingbyHotelId(@PathVariable String hotelId)
    {
        List<Rating> ratingbyhotelid=ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingbyhotelid);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getallUser()
    {
        List<Rating> ratings=ratingService.getallRatings();
        return ResponseEntity.ok(ratings);
    }

}
