package com.example.demo.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.demo.model.UserDTO;
import com.example.demo.repository.MyRepository;
@Component
  
public class Service {
	@Autowired  
	private  MyRepository myRepository;

	public void save(UserDTO dto) {
	  myRepository.save(dto);
		
}
	public List<UserDTO> read() {

		List<UserDTO> read = myRepository.findAll();
		return read;
	}
	//edit
	   public UserDTO edit(int id) {
		
		UserDTO findById = myRepository.findById(id).orElse(null);
		return findById;
	}

	public void update(UserDTO dto) {
		UserDTO update = myRepository.findById(dto.getId()).orElse(null);
		update.setName(dto.getName());
		update.setAddress(dto.getAddress());
		
		myRepository.save(update);
	}
	public void delete(int id)   
	{  
	myRepository.deleteById(id);  
	}  
	}


	

		
	

	 
	 
	
		
		
	
	

