package com.project.dao;

import com.project.dto.AdminDTO;

public interface AdminDao {
	boolean isAdminSave(AdminDTO admin);
	boolean isAdminDeleted(String username);
}
