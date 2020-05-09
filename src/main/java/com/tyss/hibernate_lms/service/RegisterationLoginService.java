package com.tyss.hibernate_lms.service;

import com.tyss.hibernate_lms.dto.UserBean;

public interface RegisterationLoginService {
	UserBean login(String email, String password);
	boolean register(UserBean bean);
}
