package com.apoorv.hotel.HotelService.service;

import com.apoorv.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String id);
}
