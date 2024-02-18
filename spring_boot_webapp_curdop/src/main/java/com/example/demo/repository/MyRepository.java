package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserDTO;


public interface MyRepository  extends JpaRepository <UserDTO, Integer>{

	
	}


