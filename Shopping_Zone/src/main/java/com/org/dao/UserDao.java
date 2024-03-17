package com.org.dao;

import com.org.dto.User;

public interface UserDao {
	void saveUser(User user);
	User fetUserByEmailAndPassword(String email,String password);
	User fetchUserById(int id);
	
}
