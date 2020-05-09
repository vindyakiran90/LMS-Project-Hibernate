package com.tyss.hibernate_lms.factory;

import com.tyss.hibernate_lms.dao.AdminDAO;
import com.tyss.hibernate_lms.dao.AdminDAOImplementation;
import com.tyss.hibernate_lms.service.AdminService;
import com.tyss.hibernate_lms.service.AdminServiceImplementation;

public class AdminFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	
}
