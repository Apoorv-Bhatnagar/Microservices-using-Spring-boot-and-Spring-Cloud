package com.apoorv.user.service.UserService.repositories;

import com.apoorv.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
