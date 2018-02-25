package com.example.demo.dzj.ebuy.service;

import com.example.demo.dzj.ebuy.dto.UserExecution;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.exception.UserException;

public interface UserService {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	UserExecution addUser(User user) throws UserException;
	
	/**
	 * 根据用户id查询
	 * @param userId
	 * @return
	 */
	UserExecution queryUserByUserId(Long userId);
	
	/**
	 * 根据用户姓名 和 密码查询
	 * @param username
	 * @param password
	 * @return
	 * @throws UserException
	 */
	UserExecution queryUserByUserNameandPassword(String username,String password) throws UserException;
}
