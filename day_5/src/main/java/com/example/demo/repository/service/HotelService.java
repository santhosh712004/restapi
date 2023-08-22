package com.example.demo.repository.service;
import com.example.demo.model.HotelModel;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.HotelRepo;
  
@Service
public class HotelService {
	@Autowired
    public HotelRepo hrepo;
	//post hotel
	public String saveHotel(HotelModel h) {
		hrepo.save(h);
		return "Data is saved to database";
	}
	//get the data
	public List<HotelModel>getHotel(){
		return hrepo.findAll();
	}
	//update the data(put)
	public HotelModel updateHotel(HotelModel hm) {
		return hrepo.saveAndFlush(hm);
	}
	//delete the data
	public void deleteHotel(int hotel_Id) {
		System.out.println("Deleted");
		hrepo.deleteById(hotel_Id);
	}

	public boolean deleteHotelif(int hotel_id) {
		if(hrepo.existsById(hotel_id)) {
			hrepo.deleteById(hotel_id);
			return true;
		}
		else {       
             return false;
		}
	}
	
	@GetMapping("/users/userId")
	public Optional<HotelModel>getuserById(int userId)
	{
		Optional<HotelModel>hotel=hrepo.findById(userId);
		if(hotel.isPresent()) {
			return hotel;
		}
		else {
			return null;
		}
	}
	
}