package com.apoorv.user.service.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
public class User  {
    @Id
    @Column(name="id")
     private String id;
    @Column(name="name")
     private String name;
    @Column(name="email")
     private String email;
    @Column(name="about")
     private String about;
    @Transient
    List<Rating> ratings=new ArrayList<>();

}
