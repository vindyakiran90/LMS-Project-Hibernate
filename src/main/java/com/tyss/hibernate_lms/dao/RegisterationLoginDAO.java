package com.tyss.hibernate_lms.dao;

import com.tyss.hibernate_lms.dto.UserBean;

public interface RegisterationLoginDAO {
	UserBean login(String email, String password);
	boolean register(UserBean bean);
}
