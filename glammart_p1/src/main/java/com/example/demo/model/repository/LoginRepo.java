package com.example.demo.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LoginEntity;


public interface LoginRepo extends JpaRepository<LoginEntity, String>{


}
