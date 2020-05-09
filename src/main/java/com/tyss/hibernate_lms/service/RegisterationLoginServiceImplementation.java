package com.tyss.hibernate_lms.service;

import com.tyss.hibernate_lms.dao.RegisterationLoginDAO;
import com.tyss.hibernate_lms.dto.UserBean;
import com.tyss.hibernate_lms.factory.RegisterationLoginFactory;

public class RegisterationLoginServiceImplementation implements RegisterationLoginService {

	RegisterationLoginDAO dao = RegisterationLoginFactory.getRegisterationLoginDAO();
	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean register(UserBean bean) {
		return dao.register(bean);
	}

}
