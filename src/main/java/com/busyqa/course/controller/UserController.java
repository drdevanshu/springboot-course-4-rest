package com.busyqa.course.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busyqa.course.jpa.User;
import com.busyqa.course.service.UserService;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping(value ={"/", "/index"})
	public String index() {
				
		//logger.debug("Show Index!!!");
				
		return "index";
	}
	
	@GetMapping(value = "/listUsers")
	public ModelAndView listUsers(){

        List<User> users = this.userService.listUsers();
       
        users.forEach(u -> logger.debug(u.toString()));
       
        return new ModelAndView("listUsers","users",users);
    }	
	
	@GetMapping(value = "/inputUser")
	public String inputUser(){
		//logger.debug("Show Input User!!!");
		
        return "inputUser";
    }	
	
	@PostMapping(value = "/createUser")
    public String createUser(HttpServletRequest request) throws ParseException {

		//logger.debug("Creating User!!!");
		
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birth = request.getParameter("birth");
        
        this.userService.createUser(firstName,lastName,username,password,birth);

        return "redirect:/listUsers";
    }	

	@GetMapping(value = "/showUser")
    public ModelAndView showUser(@RequestParam("id") int id) {

		//logger.debug("Show User!!!");
		
        User user = this.userService.findUser(id);

        return new ModelAndView("showUser","user",user);
    }	
	
	@PostMapping(value = "/updateUser")
    public String updateUser(HttpServletRequest request) throws ParseException {
       
		//logger.debug("Updating User!!!");
		
        String idUser = request.getParameter("id");
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birth = request.getParameter("birth");

        this.userService.updateUser(idUser,firstName,lastName,username,password,birth);

        return "redirect:/listUsers";
    }

	@GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") int id){

        this.userService.deleteUser(id);

        return "redirect:/listUsers";
    }
    

}
