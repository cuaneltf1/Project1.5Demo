package com.fdesign.daos;

import java.util.List;

import com.fdesign.models.User;
import com.fdesign.models.UserSecure;

public interface UserDao {
	 
	UserDao currentImplementation = new UserDaoSQL();
	
	List<UserSecure> findRegularUsers(); //Works
	
	User loginAuthentication(String username, String password); //Works

}
