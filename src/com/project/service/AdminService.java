package com.project.service;

import com.project.dto.AdminDTO;

public interface AdminService {
	boolean isAdminSave(AdminDTO admin);
	boolean isAdminDeleted(String username);
}
