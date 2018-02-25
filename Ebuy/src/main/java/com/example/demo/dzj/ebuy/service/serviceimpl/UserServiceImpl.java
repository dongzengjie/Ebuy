package com.example.demo.dzj.ebuy.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.UserDao;
import com.example.demo.dzj.ebuy.dto.UserExecution;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.enums.UserEnum;
import com.example.demo.dzj.ebuy.exception.UserException;
import com.example.demo.dzj.ebuy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	
	

	@Transactional
	public UserExecution addUser(User user) throws UserException {

		if (user != null) {
			try {
				User tempuser = userdao.queryUserByUserName(user.getUsername());
				if (tempuser != null) {
					return new UserExecution(UserEnum.HAVE_USER);
				}

				int effect = userdao.addUser(user);
				if (effect <= 0) {
					return new UserExecution(UserEnum.INNER_ERROR);
				} else {
					return new UserExecution(UserEnum.SUCCESS, user);
				}

			} catch (Exception e) {
				throw new UserException(e.getMessage());
			}

		} else {
			return new UserExecution(UserEnum.INNER_ERROR);
		}

	}

	@Transactional
	public UserExecution queryUserByUserId(Long userId) {
		if (userId != null) {

			User user = userdao.queryUserByUserId(userId);
			if(user !=null) {
				return new UserExecution(UserEnum.SUCCESS, user);
			}else {
				return new UserExecution(UserEnum.QUERY_ERROR);
			}
			
		} else {
			return new UserExecution(UserEnum.QUERY_ERROR);
		}

	}

	@Transactional
	public UserExecution queryUserByUserNameandPassword(String username, String password) throws UserException {
		
		User user =userdao.queryUserByUserNameAndPassword(username, password);
		if(user ==null) {
			return new UserExecution(UserEnum.NO_USER);
		}else {
			return new UserExecution(UserEnum.SUCCESS, user);
		}
	
	}

}
