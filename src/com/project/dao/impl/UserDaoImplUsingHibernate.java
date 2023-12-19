package com.project.dao.impl;

import java.util.List;
import com.project.dao.UserDao;
import com.project.dto.UserDTO;

public class UserDaoImplUsingHibernate implements UserDao {

	@Override
	public boolean saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(UserDTO user) {
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
