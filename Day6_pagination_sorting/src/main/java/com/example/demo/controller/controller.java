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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.model;
import com.example.demo.service.service;

@RestController
public class controller {
	@Autowired
	public service serv;
	
	//post mapping
	@PostMapping("/postPro")
	public String postmatrix(@RequestBody model mr)
	{
		serv.saveMatrix(mr);
		return "your data is saved in database";
	}
	
	//get mapping
	@GetMapping("/getPro")
	public  List<model> getmatrix()
	{
		return serv.getMatrix();
	}
	
	//put mapping
	@PutMapping("/putPro")
	public model updatematrix(@RequestBody model mrs)
	{
		return serv.updatematrix(mrs);
	}
	
	
	@DeleteMapping("/byReqParm")
	public String removeByRequest(@RequestParam ("id") int id)
	{
		serv.deletematrix(id);
		return "Matrix with id "+id+" is deleted";
	}
	
	//if there is no id
	@DeleteMapping("/deleteProif/{id}")
	public ResponseEntity<String> deleteMatrix(@PathVariable int id){
		boolean deleted = serv.deletematrixif(id);
		if(deleted) {
			return ResponseEntity.ok("Hotel with ID "+id+" deleted successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product with ID "+id+" not found");
		}
	}
	//getUserById
		@GetMapping("users/{userId}")
		public ResponseEntity<?> getUserById(@PathVariable int userId)
		{
	         Optional<model> hotel = serv.getuserById(userId);
			if(hotel != null) {
				return ResponseEntity.ok(hotel);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotel);
		}
		//sorting
		@GetMapping("/sortAsc/{name}")
		public List<model> sortasc(@PathVariable("name") String name)
		{
			return serv.sortByAsc(name);
		}
		//paginationAndSorting
		@GetMapping("/pagination/{number}/{size}/{name}")
		public List<model> pagination(@PathVariable("number")int number,@PathVariable("size")int size,@PathVariable("name")String name)
		{
			return serv.pagination(number, size,name);
		}
}