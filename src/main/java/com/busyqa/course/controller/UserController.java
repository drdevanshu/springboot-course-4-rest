package com.busyqa.course.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busyqa.course.bean.UserBean;
import com.busyqa.course.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@GetMapping(value ={"/", "/index"})
	public String index() {
				
		System.out.println("Show Index!!!");
				
		return "index";
	}
	
	@GetMapping(value = "/listUsers")
	public ModelAndView listUsers(){

        List<UserBean> users = userService.listUsers();

        for (UserBean user: users){
            System.out.println(user);
        }
        
        return new ModelAndView("listUsers","users",users);
    }	
	
	@GetMapping(value = "/inputUser")
	public String inputUser(){
       
        return "inputUser";
    }	
	
	@PostMapping(value = "/createUser")
    public String createUser(HttpServletRequest request) throws ParseException {

        UserBean user = new UserBean();

        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String birth = request.getParameter("birth");

        user.setFirstName(first.trim());
        user.setLastName(last.trim());
        user.setUserName(userName.trim());
        user.setPassword(password.trim());
        user.setBirth(this.parseDate(birth.trim()));
        
        this.userService.createUser(user);

        return "redirect:/listUsers";
    }	

	@GetMapping(value = "/showUser")
    public ModelAndView showUser(@RequestParam("id") int id) {

        UserBean user = this.userService.findUser(id);

        return new ModelAndView("showUser","user",user);
    }	
	
	@PostMapping(value = "/modifyUser")
    public String modifyUser(HttpServletRequest request) throws ParseException {

        UserBean user = new UserBean();
       
        String id = request.getParameter("id");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String birth = request.getParameter("birth");

        user.setIdUser(Integer.parseInt(id.trim()));
        user.setFirstName(first.trim());
        user.setLastName(last.trim());
        user.setUserName(userName.trim());
        user.setPassword(password.trim());
        user.setBirth(this.parseDate(birth.trim()));

        this.userService.modifyUser(user);

        return "redirect:/listUsers";
    }

	@GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") int id){

        this.userService.deleteUser(id);

        return "redirect:/listUsers";
    }
    
    private Date parseDate(String date) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }
}
