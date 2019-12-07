package com.busyqa.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.busyqa.course.jpa.User;
import com.busyqa.course.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;

    @Transactional(readOnly=true)
    public List<User> listUsers() {

        return this.userRepository.findAll();
    }

    @Transactional(readOnly=true)
    public User findUser(int idUser){
        return this.userRepository.findById(idUser).get();
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void updateUser(String idUser,String firstName,String lastName,String username,String password,String birth) throws ParseException{

    	User user = this.findUser(Integer.parseInt(idUser));
    	
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setBirth(this.parseDate(birth));
		
		this.userRepository.save(user);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void createUser(String firstName,String lastName,String username,String password,String birth) throws ParseException{
		
    	User user = new User();
    	
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setBirth(this.parseDate(birth));
		user.setStatus("A"); /* Always created as Active */
		
		this.userRepository.save(user);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void deleteUser(int idUser){
    	
        this.userRepository.deleteById(idUser);
    }
    
    private Date parseDate(String date) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }
}
