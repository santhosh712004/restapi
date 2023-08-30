package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.orderPlace;
import com.example.demo.service.service;

@RestController
public class control {
@Autowired
service sser;
@PostMapping()
public List<orderPlace> disp(@RequestBody List<orderPlace> ss)
{
	return sser.saveinfo(ss);
}

@GetMapping()
public List<orderPlace> dis()
{
	return sser.showinfo();
}
@GetMapping("/get/{phone_no}")
public Optional<orderPlace> getid(@PathVariable Long phone_no)
{
	return sser.getbyid(phone_no);
}
@PutMapping("/put")
public orderPlace update(@RequestBody orderPlace ss)
{
	return sser.updateinfo(ss);
}
@PutMapping("/put/{phone_no}")
public String updateby(@PathVariable Long phone_no,@RequestBody orderPlace ss)
{
	return sser.updatebyid(phone_no,ss);
}

@GetMapping("/getasc/{name}")
public List<orderPlace> sorta(@PathVariable String name)
{
	return sser.sortasc(name);
}
@GetMapping("/getdesc/{name}")
public List<orderPlace> sortd(@PathVariable String name)
{
	return sser.sortdesc(name);
}
//select or
	@GetMapping("/getn/{id}/{name}")
	public List<orderPlace> gtn(@PathVariable int age,@PathVariable String name)
	{
		return sser.gt(age, name);
	}
	//select and
	@GetMapping("/getand/{id}/{name}")
	public List<orderPlace> gan(@PathVariable int age,@PathVariable String name)
	{
		return sser.gand(age, name);
	}
//	//select like start
	@GetMapping("/getlike/{name}")
	public List<orderPlace> gli(@PathVariable String name)
	{
		return sser.gstart(name);
	}
//	//select like end
	@GetMapping("/getend/{name}")
	public List<orderPlace> gen(@PathVariable String name)
	{
		return sser.gend(name);
	}
	//update
	@PutMapping("/update/{name}/{id}")
	public Integer ut(@PathVariable String name,@PathVariable String id)
	{
		return sser.updat(name,id);
	}
	//delete
	@DeleteMapping("/del/{id}")
	public Integer de(@PathVariable int id)
	{
		return sser.del(id);
	}
	@GetMapping("sortandpage/{pgno}/{pgsize}")
	public List<orderPlace>sortpage(@PathVariable int pgno,@PathVariable int pgsize){
		return sser.getbypage(pgno, pgsize);
	}
}
