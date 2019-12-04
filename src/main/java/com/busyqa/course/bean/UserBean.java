package com.busyqa.course.bean;

import java.util.Date;
import java.util.Set;

public class UserBean {

    int idUser;
    
    String userName;
    
    String password;
    
    String firstName;
    
    String lastName;
    
    Date birth;
    
    Set<PrivilegeBean> privileges;
    

	public UserBean() {
		super();
	}

	public UserBean(int idUser, String userName, String password, String firstName, String lastName, Date birth,
			Set<PrivilegeBean> privileges) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.privileges = privileges;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Set<PrivilegeBean> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<PrivilegeBean> privileges) {
		this.privileges = privileges;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBean [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birth=" + birth + ", privileges=" + privileges + "]";
	}



}
