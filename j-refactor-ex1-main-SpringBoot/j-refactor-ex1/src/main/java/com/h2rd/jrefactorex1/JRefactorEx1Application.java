package com.h2rd.jrefactorex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.h2rd.refactoring.controller.UserResource;
import com.h2rd.refactoring.dao.UserDao;
import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;

@SpringBootApplication
@ComponentScan(basePackageClasses = {UserResource.class, UserService.class, UserDao.class, User.class})
public class JRefactorEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(JRefactorEx1Application.class, args);
	}

}
