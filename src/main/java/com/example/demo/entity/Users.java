package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details")
public class Users {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String userName;
   private String password;
   private String email;
   private boolean isActive;
   private String role;
}
