package com.example.mywebapp.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.mywebapp.Entities.product;

import java.util.List;

public interface productDao extends JpaRepository<product,Integer> {


    List<product> findByUserId(int user_id);


}
