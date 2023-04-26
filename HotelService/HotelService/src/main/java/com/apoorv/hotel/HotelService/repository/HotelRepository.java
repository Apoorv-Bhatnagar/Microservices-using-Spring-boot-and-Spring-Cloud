package com.apoorv.hotel.HotelService.repository;

import com.apoorv.hotel.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
