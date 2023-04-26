package com.apoorv.rating.RatingService.repository;

import com.apoorv.rating.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByhotelId(String hotelId);

}
