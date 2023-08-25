package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.model;
import com.example.demo.repository.rep;

@Service
public class service {
	@Autowired
	public rep grepo;
	
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
    //sorting
    public List<model> sortByAsc(String name)
	{
		return grepo.findAll(Sort.by(name).ascending());
	}
    //pagination
    public List<model> pagination(int pageNu,int pageSize)
    {
    	Page<model> cont = grepo.findAll(PageRequest.of(pageNu, pageSize));
    	return cont.getContent();
    }
  //paginationAndSorting
    public List<model> pagination(int pageNu,int pageSize,String name)
    {
    	Page<model> cont = grepo.findAll(PageRequest.of(pageNu, pageSize,Sort.by(name)));
    	return cont.getContent();
    }
  //get all data
  	public List<model> getAllRows()
  	{
  		return grepo.getAllRows();
  	}
  	//get Spec data
  	public List<model> getSpecrows(String addr,String name)
  	{
  		return grepo.getSpecRows(addr, name);
  	}
  //get by Char
  	public List<model> getDataByChar(String name)
  	{
  		return grepo.getByname(name);
  	}
  	//delete the data
  	public int deleteById(int id)
  	{
  		return grepo.deleteId(id);
  	}
  	//update the data 
  	public int updateData(String addr,int no_id) {
  		return grepo.updateById(addr, no_id);
  	}
  	//using model class
  //get using model class
  	public List<model> gettingmodel()
  	{
  		return grepo.get();
  	}
  	//get using model class
  	public List<model> getDatafromModel(String name) {
  		return grepo.getByName(name);
  	}
  	//DELETE USING MODEL CLASS
  	public int deleteByName(String id)
  	{
  		return grepo.deleteName(id);
  	}
  //update by model
  	public int updateDatamodel(String addr,int no_id) {
  		return grepo.updateByIdmodel(addr, no_id);
  	}
  	
 // get specific data
    public List<model> getdatamodel(String addr,String name)
	{
		return grepo.getdataBymodel(addr, name);
	}
  	//
  	
}