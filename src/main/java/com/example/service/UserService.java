package com.example.service;

import com.example.business.User;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class UserService {

	UserDao dao = new UserDao();
	
	public User login(String username, String password){
		
		User u = null;
		try {			
			u = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public Boolean register(String firstname, String lastname, String username, String password) {
		Boolean check = false;
		try {
			check = dao.registerUser(firstname, lastname, username, password);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public Boolean updateProfile(int userID, String firstname, String lastname, String username, String password) {
		Boolean check = false;
		try {
			check = dao.updateUser(userID, firstname, lastname, username, password);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
}
