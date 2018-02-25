package com.example.demo.dzj.ebuy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dzj.ebuy.entity.User;

@Mapper
public interface UserDao {
	
	/**
	 * 添加用户信息 
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	
	User queryUserByUserName(String username);
	
	/**
	 * 根据用户Id查询用户
	 * @return
	 */
	User queryUserByUserId(Long userId);
	
	/**
	 * 根据用户名 和密码查询
	 * @param username
	 * @param password
	 * @return
	 */
	User queryUserByUserNameAndPassword(@Param("username") String username,@Param("password") String password);
}
