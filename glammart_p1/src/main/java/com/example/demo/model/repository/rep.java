package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.orderPlace;

import jakarta.transaction.Transactional;

public interface rep extends JpaRepository<orderPlace, Long>{
	@Query(value = "select*from order_Place where id=:s or name=:sn",nativeQuery = true)
	public List<orderPlace> geti(@Param("s")int id,@Param("sn") String name);
	@Query(value = "select * from order_Place where id=:4 and name=:siva",nativeQuery = true)
	public List<orderPlace> getand(@Param("4")int id,@Param("siva")String name);
	@Query(value = "select * from order_Place where name like :g%",nativeQuery = true)
	public List<orderPlace> getstart(@Param("g")String name);
	@Query(value ="select * from order_Place where name like %:gn",nativeQuery = true)
	public List<orderPlace> getend(@Param("gn") String name);
	@Modifying
	@Transactional
	@Query(value = "update order_Place set name=?1 where name=?2",nativeQuery = true)
	public Integer up(@Param("s")String name,@Param("s1") String name1);
	@Modifying
	@Transactional
	@Query(value="delete from order_Place where id=:s3",nativeQuery = true)
	public Integer de(@Param("s3")int id);
}