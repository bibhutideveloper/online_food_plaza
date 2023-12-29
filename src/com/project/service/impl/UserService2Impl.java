package com.project.service.impl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.dao.impl.UserDaoImplUsingJdbc;
import com.project.dto.UserDTO;
import com.project.service.UserService;

public class UserService2Impl implements UserService {

	UserDao userDao  = new UserDaoImplUsingJdbc();
	
	@Override
	public boolean saveUser(UserDTO user) {
		return userDao.saveUser(user);
	}

	@Override
	public boolean updateUSer(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDTO> searchUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> showAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
