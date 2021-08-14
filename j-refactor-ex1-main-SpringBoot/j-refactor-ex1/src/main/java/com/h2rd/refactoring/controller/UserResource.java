package com.h2rd.refactoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;

@RestController
@RequestMapping("/j-refactor-ex1/users")
public class UserResource {

    @Autowired
    UserService userService;

    @RequestMapping(value="/add", method=RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addUser(@RequestBody User user) {
        
        return userService.addUser(user);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT,
	consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
    	return userService.updateUser(user);
    }

    @RequestMapping(value="/delete/{email}", method=RequestMethod.DELETE,
    		 produces = MediaType.ALL_VALUE)
    public void deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
        
    }

    @RequestMapping(value="/find", method=RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
    	
    	return userService.getUsers();
    }

    @RequestMapping(value="/search/{name}", method=RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable("name") String name) {
    	User user = null;
    	if(name!=null) {
    		user = userService.findUser(name);
    	}
        return user;
    }
}
