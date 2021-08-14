package com.h2rd.jrefactorex1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.h2rd.refactoring.controller.UserResource;
import com.h2rd.refactoring.dao.UserDao;
import com.h2rd.refactoring.usermanagement.User;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceUnitTest {

	@InjectMocks
    UserResource userResource;
	
	@Mock
    UserDao userDao;

    @Test
    public void addUserTestWithNoEmail() {

        userResource = new UserResource();
        
        User user = new User();
        user.setName("Rahul");
        List<String> roles = new ArrayList<String>();
        roles.add("Student");
        user.setRoles(roles);

        
        try {
			userResource.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

        List<User> response = userResource.getUsers();
        Assert.assertFalse(response.isEmpty()==true);
    }
    
    @Test
    public void addUserTestWithNoRoles() {

        userResource = new UserResource();
        
        User user = new User();
        user.setName("Rahul");
        user.setEmail("Rahul@gmail.com");
        List<String> roles = new ArrayList<String>();
        user.setRoles(roles);

        
        try {
			userResource.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

        List<User> response = userResource.getUsers();
        Assert.assertTrue(response!=null);
    }
    
    @Test
    public void addUserTest() {

        userResource = new UserResource();
        
        User user = new User();
        user.setName("Rahul");
        user.setEmail("Rahul@gmail.com");
        List<String> roles = new ArrayList<String>();
        roles.add("Student");
        user.setRoles(roles);

        
        try {
			userResource.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

        List<User> response = userResource.getUsers();
        Assert.assertTrue(response!=null);
    }
}
