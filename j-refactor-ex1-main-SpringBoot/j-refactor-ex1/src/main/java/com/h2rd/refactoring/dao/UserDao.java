package com.h2rd.refactoring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.h2rd.refactoring.usermanagement.User;

@Repository
public class UserDao {

	public List<User> users = new ArrayList<User>();;

	public static UserDao userDao;

	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}

	public Boolean saveUser(User user) {
		if (users == null) {
			users = new ArrayList<User>();
		}
		for (User newUser : users) {
			if (newUser.getEmail().equals(user.getEmail()) || user.getRoles().isEmpty()) {
				return false;
			}
		}
		users.add(user);
		return true;
	}

	public List<User> getUsers() {
		try {
			return users;
		} catch (Throwable e) {
			System.out.println("error");
			return null;
		}
	}

	public void deleteUser(String email) {
		try {

			users.removeIf(user -> user.getEmail().equals(email));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User userToUpdate) {
		try {
			for (User user : users) {
				if (user.getName().equals(userToUpdate.getName())) {
					user.setEmail(userToUpdate.getEmail());
					user.setRoles(userToUpdate.getRoles());
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public User findUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
}
