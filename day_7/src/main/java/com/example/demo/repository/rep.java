package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.model;

import jakarta.transaction.Transactional;


public interface rep extends JpaRepository<model, Integer> {
	//native Query
		@Query(value = "select * from model",nativeQuery = true)
		public List<model> getAllRows();
		
		@Query(value = "select * from model where city =:addr and name =:name" ,nativeQuery = true)
		public List<model> getSpecRows(@Param("addr") String addr,@Param("name") String name);
		//get by char
		@Query (value = "select * from model where name like %?1%",nativeQuery = true)
		public List<model> getByname(@Param("name") String name);
		//delete using native query
		@Modifying
		@Transactional
		@Query(value = "delete from model where id=:no_id",nativeQuery = true)
		public int deleteId(@Param("no_id") int id);
		
		@Modifying
		@Transactional
		@Query(value="update model set city=:addr where id=:no_id",nativeQuery = true)
		public int updateById(@Param("addr") String addr,@Param("no_id") int id);
		
		
		//get by using model class
	    @Query("select t from model t")
		public List<model> get();
		
		@Query("select a from model a where a.name  like %?1%")
		public List<model>getByName(@Param("name")String name);
		
		@Query("select b from model b where b.id=:id")
		public int deleteName(@Param("id")String id);
		
		@Modifying
		@Transactional
		@Query("update model t set t.name=:addr where t.id=:no_id")
		public int updateByIdmodel(@Param("addr") String addr,@Param("no_id") int id);
		
		//get using id by model class
	    @Query("select t from model t where t.name =:addr and t.name =:name")
		public List<model> getdataBymodel(@Param("addr") String addr,@Param("name") String name);

}