package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.model;
import com.example.demo.repository.repo;

@Service
public class service {
	@Autowired
	public repo grepo;
	
	//post the data
	public String saveMatrix(model m)
	{
		 grepo.save(m);
		 return "Data is saved";
		
	}
	
	//get the data
    public List<model> getMatrix()
	{
		 return grepo.findAll();
			
	}
    // update the data
    public model updatematrix (model mm)
    {
    	return grepo.saveAndFlush(mm);
    }
    //delete the data
    public void deletematrix(int humans) {
    	grepo.deleteById(humans);
    }
    //delete data
    public boolean deletematrixif(int humans)
    {
    	if(grepo.existsById(humans)) {
    		grepo.deleteById(humans);
    		return true;
    	}else {
    		return false;
    	}
    }
  //getUserId
    @GetMapping("/users/userId")
    
    public Optional<model> getuserById(int userId)
    {
    	Optional<model> hotel = grepo.findById(userId);
    	if(hotel.isPresent()) {
    		return hotel;
    	}
    	else
    	{
    		return null;
    	}
    }
}