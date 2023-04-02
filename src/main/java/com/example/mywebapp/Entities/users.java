package com.example.mywebapp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class users{


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    @Column(name="user_id")
    int user_id;
    @Column(name="name")
    String name;

    @Column(name="surname")
    String surname;

    @Column(name="email")
    String email;

    @Column(name="password")
    String  password;


}
