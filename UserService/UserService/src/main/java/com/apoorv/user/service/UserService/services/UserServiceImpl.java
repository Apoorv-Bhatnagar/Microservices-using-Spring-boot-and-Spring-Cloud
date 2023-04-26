package com.apoorv.user.service.UserService.services;

import com.apoorv.user.service.UserService.entities.Hotel;
import com.apoorv.user.service.UserService.entities.Rating;
import com.apoorv.user.service.UserService.entities.User;
import com.apoorv.user.service.UserService.exception.ResourceNotFoundException;
import com.apoorv.user.service.UserService.external_services.HotelService;
import com.apoorv.user.service.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    @Override
    public User saveUser(User user) {
        String userId=UUID.randomUUID().toString();
        user.setId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getallUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found"));
       Rating[] r=restTemplate.getForObject("http://Rating-Service/ratings/users/"+userId, Rating[].class);
      List<Rating> ratings= Arrays.asList(r);
       for(Rating obj:ratings)
       {
          Hotel hotel= restTemplate.getForObject("http://Hotel-Service/hotels/"+obj.getHotelId(), Hotel.class);
     //  Hotel hotel=hotelService.getHotel(obj.getHotelId());
          obj.setHotel(hotel);
       }
       user.setRatings(ratings);
        return user;
    }
}
