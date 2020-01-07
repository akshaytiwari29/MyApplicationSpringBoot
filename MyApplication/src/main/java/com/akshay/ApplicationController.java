package com.akshay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akshay.modal.User;
import com.akshay.services.UserService;

@Controller
public class ApplicationController 
{

	@Autowired
	UserService userService;
	
@ResponseBody
@RequestMapping("/hello")	
public String display()

{
	return "hello from spring";
}

@RequestMapping("/welcome")
public String Welcome(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_HOME");
	return "welcomepage";
}

@RequestMapping("/register")
public String registration(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_REGISTER");
	return "welcomepage";
}

@PostMapping("/save-user")
public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
	userService.saveMyUser(user);
	request.setAttribute("mode", "MODE_HOME");
	return "welcomepage";
}


@GetMapping("/show-users")
public String showAllUser(HttpServletRequest request)

{
	request.setAttribute("users",userService.showAllUser());
    request.setAttribute("mode","ALL_USERS");	
	return "welcomepage";
	
}

@RequestMapping("/delete-user")
public String deleteUser(@RequestParam int id, HttpServletRequest request) {
	userService.deletmyuser(id);
	request.setAttribute("users", userService.showAllUser());
	request.setAttribute("mode", "ALL_USERS");
	return "welcomepage";

}

/*@RequestMapping("/edit-user")
public String editUser(@RequestParam int id,HttpServletRequest request) {
	request.setAttribute("user", userService.editUser(id));
	request.setAttribute("mode", "MODE_UPDATE");
	return "welcomepage";
}*/
}
