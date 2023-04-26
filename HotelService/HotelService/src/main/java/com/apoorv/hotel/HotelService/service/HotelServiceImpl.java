package com.apoorv.hotel.HotelService.service;

import com.apoorv.hotel.HotelService.entity.Hotel;
import com.apoorv.hotel.HotelService.exception.ResourceNotFoundException;
import com.apoorv.hotel.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        Hotel hotel1=hotelRepository.save(hotel);
        return hotel1;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels=hotelRepository.findAll();
        return hotels;
    }

    @Override
    public Hotel get(String id) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found on server"));
        return hotel;
    }
}
