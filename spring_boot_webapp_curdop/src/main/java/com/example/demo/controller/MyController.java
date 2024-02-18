package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserDTO;
import com.example.demo.service.Service;

@Controller
public class MyController {
	@Autowired
	private Service service;
	@GetMapping("/")
	public String link1() {
		return "index";
}

	 @GetMapping("/registration")
	    public String registration(@ModelAttribute UserDTO dto) {
	        service.save(dto); // Assuming your Service class has a save method.
	        System.out.println(dto); // You might want to print the saved user data.
	        return "index2";
	    }

	 @GetMapping("/link2")
		public ModelAndView link2() {
			List<UserDTO> read = service.read();
			System.out.println(read);
			
			return new ModelAndView("index3","user",read);
	 
		}
	 //edit
	 @GetMapping(value="/Edit/{id}")
		public ModelAndView edit(@PathVariable int id) {
			UserDTO edit = service.edit(id);
	
			System.out.println(edit);
			return new ModelAndView("index4","edit1", edit);
		}
		@GetMapping(value="/sav")
		public String sav(@ModelAttribute UserDTO dto) {
			service.update(dto);
			return"index5";
     }
		@GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable int id) {
	        service.delete(id);
	        return "index6";   
		 }
}
		
		 
		
		  




	
	 
	
