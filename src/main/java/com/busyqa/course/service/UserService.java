package com.busyqa.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busyqa.course.bean.UserBean;
import com.busyqa.course.dao.IUserDao;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserDao userDao;

	@Override
    public List<UserBean> listUsers() {

        //
        List<UserBean> users = userDao.listUsers();

        // Important code that manipulates the user list.

        return users;
    }

	@Override
    public UserBean findUser(int idUsuario){
        return this.userDao.findUser(idUsuario);
    }

	@Override
    public void modifyUser(UserBean user){
		this.userDao.modifyUser(user);
    }

	@Override
    public void createUser(UserBean user){
		this.userDao.createUser(user);
    }

	@Override
    public void deleteUser(int idUser){
        this.userDao.deleteUser(idUser);
    }
}
