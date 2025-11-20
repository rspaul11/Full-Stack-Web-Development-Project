package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {
	
	List<User> getAllUsers();
	User getUser(int userid);
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int userid);
	
	User getUserByEmail(String email);

	}