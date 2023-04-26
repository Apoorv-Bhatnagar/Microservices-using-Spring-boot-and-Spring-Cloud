package com.apoorv.rating.RatingService.service;

import com.apoorv.rating.RatingService.entity.Rating;
import com.apoorv.rating.RatingService.exception.ResourceNotFoundException;
import com.apoorv.rating.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    public RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String id= UUID.randomUUID().toString();
        rating.setRatingId(id);
         ratingRepository.save(rating);
         return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getallRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hostelId) {
        return ratingRepository.findByhotelId(hostelId);
    }
}
