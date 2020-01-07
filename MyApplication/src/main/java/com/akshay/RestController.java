package com.akshay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.modal.User;
import com.akshay.services.UserService;


@org.springframework.web.bind.annotation.RestController
public class RestController 
{
	
	@Autowired
	private UserService userservice;
	@GetMapping("/")
	public String hello()
	
	{
		return "This is rest controller";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
	
	{
		User user =new User(username,firstname,lastname,age,password);
		
	    userservice.saveMyUser(user);
		return "user is saved";
	}
	
	
	

}
