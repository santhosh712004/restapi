package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.HotelModel;
import com.example.demo.repository.service.HotelService;

@RestController
public class HotelController {
	@Autowired
public HotelService hserv;
	@PostMapping("/postHotel")
	public String postHotel(@RequestBody HotelModel hr) {
		hserv.saveHotel(hr);
		return "data saved";
	}
	@GetMapping("/getHotel")
	public List<HotelModel>getHotelInfo(){
		return hserv.getHotel();
	}
	@PutMapping("/updateHotel")
	public HotelModel updateHotelInfo(@RequestBody HotelModel ha) {
		return hserv.updateHotel(ha);
	}
	//delete mapping
	@DeleteMapping("/deleteHotelif/{Id}")
	public ResponseEntity<String> deleteHotelinfo(@PathVariable int Id){
		boolean deleted =hserv.deleteHotelif(Id);
		if(deleted) {
			return ResponseEntity.ok("Hotel with ID "+Id+" deleted successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+Id+" not found");
		}
	}
	//getUserById
		@GetMapping("user/{userId}")
		public ResponseEntity<?> getuserById(@PathVariable int userId)
		{
	        Optional<HotelModel> hotel = hserv.getuserById(userId);
			if(hotel != null) {
				return ResponseEntity.ok(hotel);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotel);
		}
}
	
	

