package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.orderPlace;
import com.example.demo.model.repository.rep;

@Service
public class service {
@Autowired
rep sr;
public List<orderPlace> saveinfo(List<orderPlace> ss)
{
	return sr.saveAll(ss);
}
public List<orderPlace> showinfo()
{
	return sr.findAll();
}
public Optional<orderPlace> getbyid(Long phone_no)
{
	return sr.findById(phone_no);
}
public orderPlace updateinfo(orderPlace ss)
{
	return sr.saveAndFlush(ss);
}
public String updatebyid(Long phone_no,orderPlace ss)
{
	sr.saveAndFlush(ss);
	 if(sr.existsById(phone_no))
	 {
		 return "valid number";
	 }
	 else
	 {
		 return "please enter the valid number";
	 }
}

public List<orderPlace> sortasc(String name)
{
	return sr.findAll(Sort.by(Sort.Direction.ASC,name));
}
public List<orderPlace> sortdesc(String name)
{
	return sr.findAll(Sort.by(Sort.Direction.DESC,name));
}
public List<orderPlace> pagging(int pgno,int pgsize)
{
	Page<orderPlace> p=sr.findAll(PageRequest.of(pgno, pgsize));
	return p.getContent();
	}
//select for or statement
public List<orderPlace> gt(int age,String name)
{
	return sr.geti(age, name);
}
//select for and statement
public List<orderPlace> gand(int age,String name)
{
	return sr.getand(age, name);
}
//select for like start
public List<orderPlace> gstart(String name)
{
	return sr.getstart(name);
}
//select for like end
public List<orderPlace> gend(String name)
{
	return sr.getend(name);
}
//update
public Integer updat(String name,String name1)
{
	return sr.up(name,name1);
}
//delete
public Integer del(int id)
{
	return sr.de(id);
}
public List<orderPlace> getbypage(int pgno,int pgsize){
	Page<orderPlace> p=sr.findAll(PageRequest.of(pgno, pgsize));
	return p.getContent();
}
}