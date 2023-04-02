package com.example.mywebapp.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mywebapp.Entities.users;
public interface userDao extends JpaRepository<users,Integer> {


}
