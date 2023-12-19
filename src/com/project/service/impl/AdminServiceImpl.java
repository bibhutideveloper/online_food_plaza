package com.project.service.impl;

import com.project.dto.AdminDTO;
import com.project.service.AdminService;
import com.project.dao.AdminDao;
import com.project.dao.impl.AdminDaoImplusingJdbc;

public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImplusingJdbc();
	
	@Override
	public boolean isAdminSave(AdminDTO admin) {
		return adminDao.isAdminSave(admin);
	}

	@Override
	public boolean isAdminDeleted(String username) {
		return adminDao.isAdminDeleted(username);
	}

}
