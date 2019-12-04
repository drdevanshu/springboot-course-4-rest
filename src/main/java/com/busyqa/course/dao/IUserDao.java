package com.busyqa.course.dao;

import java.util.List;

import com.busyqa.course.bean.UserBean;


public interface IUserDao {

	List<UserBean> listUsers();
	
	UserBean findUser(int idUser);

	void createUser(UserBean user);
	
	void modifyUser(UserBean user);
	
	void deleteUser(int idUser);
}
