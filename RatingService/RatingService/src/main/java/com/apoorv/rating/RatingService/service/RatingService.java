package com.apoorv.rating.RatingService.service;

import com.apoorv.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating hotel);
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getallRatings();
    List<Rating> getRatingByHotelId(String hostelId);
}
