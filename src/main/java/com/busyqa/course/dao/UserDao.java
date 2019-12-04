package com.busyqa.course.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.busyqa.course.bean.PrivilegeBean;
import com.busyqa.course.bean.UserBean;

@Repository
public class UserDao implements IUserDao{


	List<UserBean> users;
	
    public UserDao() {
		super();

		this.users = new ArrayList<>();

		this.users.add(new UserBean(1,"fkrumm","123","Fredrick","Krumm",   new Date(969681600000l),this.createPrivileges()));
		this.users.add(new UserBean(2,"jdunning","123","Jaymie","Dunning", new Date(913231600000l),this.createPrivileges()));
		this.users.add(new UserBean(3,"krayford","123","Kristy","Rayford", new Date(965636464677l),this.createPrivileges()));
		this.users.add(new UserBean(4,"fredington","123","Faye","Redington", new Date(924567556444l),this.createPrivileges()));
		this.users.add(new UserBean(5,"bstinebaugh","123","Bobbye","Stinebaugh", new Date(965363444440l),this.createPrivileges()));
	}

	@Override
	public List<UserBean> listUsers() {
		
        return this.users;		
	}   

    @Override
    public UserBean findUser(int idUsuario) {
    	
    	return this.users.stream()
    			.filter(u -> u.getIdUser() == idUsuario)
    			.findAny().orElse(null);  	
    }
    
    @Override
    public void createUser(UserBean user) {
     
    	int max = this.users.stream()
    			         .mapToInt(u -> u.getIdUser())
    			         .max().orElse(0);
    	
    	user.setIdUser(++max);
        this.users.add(user);    
    } 
 
    @Override
    public void modifyUser(UserBean user) {
       
        int index = this.users.indexOf(user);
        
        if (index >= 0) {
        	this.users.set(index, user);
        }
    }  
    
    @Override
    public void deleteUser(int idUser){

         this.users.removeIf(u -> u.getIdUser()==idUser);         
    }    
    
    private Set<PrivilegeBean> createPrivileges(){
    	
		Set<PrivilegeBean> privileges = new HashSet<>();
		
		privileges.add(new PrivilegeBean(1,"Admin"));
		privileges.add(new PrivilegeBean(1,"User"));
		privileges.add(new PrivilegeBean(1,"Guest"));
		
		return privileges;
    }
    
  
}
