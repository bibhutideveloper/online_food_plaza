package com.project.service.impl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.dao.impl.UserDaoImplUsingJdbc;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImplUsingJdbc();
//	private UserDao userDao = new UserDaoImplUsingHibernate();

	@Override
	public boolean saveUser(UserDTO user) {
//		System.out.println(user +" from user service impl layer");
		return userDao.saveUser(user);
	}

	@Override
	public boolean updateUSer(UserDTO user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(String email) {
		return userDao.deleteUser(email);
	}

	@Override
	public List<UserDTO> searchUser(String email) {
		return userDao.searchUser(email);
	}

	@Override
	public List<UserDTO> showAllUser() {
		return userDao.showAllUser();
	}
	
}
