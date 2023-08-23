package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.glamModel;
import com.example.demo.repository.glamRep;

@Service
public class glamService {
	@Autowired
	public glamRep grepo;
	
	//post the data
	public String saveMatrix(glamModel m)
	{
		 grepo.save(m);
		 return "Data is saved";
		
	}
	
	//get the data
    public List<glamModel> getMatrix()
	{
		 return grepo.findAll();
			
	}
    // update the data
    public glamModel updatematrix (glamModel mm)
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
    
    public Optional<glamModel> getuserById(int userId)
    {
    	Optional<glamModel> hotel = grepo.findById(userId);
    	if(hotel.isPresent()) {
    		return hotel;
    	}
    	else
    	{
    		return null;
    	}
    }
}