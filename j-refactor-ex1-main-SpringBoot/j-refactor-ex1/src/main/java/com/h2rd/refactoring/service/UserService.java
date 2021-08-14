package com.h2rd.refactoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2rd.refactoring.dao.UserDao;
import com.h2rd.refactoring.usermanagement.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public boolean addUser(User user) {
		if(userDao.saveUser(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}
	
	public void deleteUser(String email) {
		userDao.deleteUser(email);
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public User findUser(String name) {
		return userDao.findUser(name);
	}
}
