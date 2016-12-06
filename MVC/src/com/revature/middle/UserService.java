package com.revature.middle;

import javax.naming.AuthenticationException;

import com.revature.beans.User;
import com.revature.data.DataFacade;

class UserService {

	User authenticate(String username,
			String password) throws AuthenticationException{
		DataFacade dataTier = new DataFacade();
		User user = dataTier.getUserByName(username);
		if(user == null) throw new AuthenticationException();
/*		if(user.getPassword().equals(password)){
			return user;
		}else{
			throw new AuthenticationException();
		}*/
		return null;
	}
	
}
