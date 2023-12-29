package com.project.service;

import java.util.List;

import com.project.dto.UserDTO;

public interface UserService {
	boolean saveUser(UserDTO user);
	boolean updateUSer(UserDTO user);
	boolean deleteUser(String email);
	List<UserDTO> searchUser(String email);	
	List<UserDTO> showAllUser();	
}
