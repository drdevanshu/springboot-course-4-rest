package com.busyqa.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busyqa.course.jpa.User;
import com.busyqa.course.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;

    @Transactional(readOnly=true)
    public Optional<User> findUser(int idUser){
        return this.userRepository.findById(idUser);
    }

}
