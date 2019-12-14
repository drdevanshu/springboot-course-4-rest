package com.busyqa.course.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.busyqa.course.jpa.User;
import com.busyqa.course.service.UserService;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/user/get")
    public User getUser(@RequestParam("id") int id) {

		logger.debug("Get User");
		
		Optional<User> opt = this.userService.findUser(id);

        if (opt.isPresent()){
            logger.info("User Found !!! - {}", opt.get());
        } else {
            logger.info("User Not Found : {}",id);
        }

        return opt.orElse(null);
    }	
}
