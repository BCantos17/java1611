package com.revature.middle;

import javax.naming.AuthenticationException;

import com.revature.beans.User;

public class BusinessDelegate {

	public User login(String user, String pass) 
			throws AuthenticationException{
		return new UserService().authenticate(user, pass);
	}
	
}
