package com.tyss.hibernate_lms.factory;

import com.tyss.hibernate_lms.dao.RegisterationLoginDAO;
import com.tyss.hibernate_lms.dao.RegisterationLoginDAOImplementation;
import com.tyss.hibernate_lms.service.RegisterationLoginService;
import com.tyss.hibernate_lms.service.RegisterationLoginServiceImplementation;

public class RegisterationLoginFactory {
	public static RegisterationLoginDAO getRegisterationLoginDAO() {
		return new RegisterationLoginDAOImplementation();
	}
	public static RegisterationLoginService getRegisterationLoginService() {
		return new RegisterationLoginServiceImplementation();
	}
}
