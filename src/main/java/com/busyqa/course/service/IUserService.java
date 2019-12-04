package com.busyqa.course.service;

import java.util.List;

import com.busyqa.course.bean.UserBean;

public interface IUserService {
	
	List<UserBean> listUsers();
	
	UserBean findUser(int idUser);

	void createUser(UserBean user);
	
	void modifyUser(UserBean user);
	
	void deleteUser(int idUser);
}
