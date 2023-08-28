package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.Studentrepo;

@RestController
@RequestMapping("/mapping")
public class relationclass {
	@Autowired
	public Studentrepo srepo;
	//post data
	@PostMapping("/posting")
	public Student postData(@RequestBody Student s)
	{
		return srepo.save(s);
	}
	//get data
	@GetMapping("getting")
	public List<Student> getData()
	{
		return srepo.findAll();
	}

}