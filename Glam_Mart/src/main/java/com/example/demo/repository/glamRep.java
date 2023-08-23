package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.glamModel;


public interface glamRep extends JpaRepository<glamModel, Integer> {

}