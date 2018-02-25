package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dto.UserExecution;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testAdd() {
/*		User user = new User();
		user.setUsername("jack");
		user.setStatus(1);

		UserExecution userExecution = userService.addUser(user);
		System.out.println(userExecution.getStateinfo());*/
	}

	@Test
	public void testquery() {

	/*	UserExecution userExecution = userService.queryUserByUserNameandPassword("jerry", "123");
		
		System.out.println(userExecution.getUser().getTrueName());*/
	}
}
