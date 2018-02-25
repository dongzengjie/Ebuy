package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.UserDao;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAdd() {
/*		User user =new User();
		user.setAddress("上海");
		user.setStatus(2);
		user.setUsername("网啥子");
		user.setEmail("2857877087@qq.com");
		user.setPassword("123456");
		int i= userDao.addUser(user);
		System.out.println(i);*/
	}
	
	@Test
	public void testselect() {
		/*User user =userDao.queryUserByUserNameAndPassword("tom", "123");
		String username=user.getUsername();
		System.out.println(username);*/
		
	}
}
