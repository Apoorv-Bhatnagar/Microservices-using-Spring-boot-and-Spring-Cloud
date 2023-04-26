package com.apoorv.user.service.UserService.external_services;

import com.apoorv.user.service.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hotel-Service")
public interface HotelService {
    @GetMapping(name="/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
