package com.tyss.hibernate_lms.dao_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.hibernate_lms.dao.RegisterationLoginDAO;
import com.tyss.hibernate_lms.dao.RegisterationLoginDAOImplementation;
import com.tyss.hibernate_lms.dto.UserBean;

public class RegisterationLoginDAOTest {

	private RegisterationLoginDAO dao = new RegisterationLoginDAOImplementation();

	@Test
	public void loginTest() {
		String email = "kushi@gmail.com";
		String password = "Lavana456@";
		UserBean userBean = dao.login(email, password);
		Assertions.assertNotNull(userBean);
	}
	
	@Test
	public void registerTest() {
		UserBean userBean = new UserBean();
		userBean.setUserId(10002);
		userBean.setFirstName("Manish");
		userBean.setLastName("Manjunath");
		userBean.setRole("Student");
		userBean.setPhoneNo(9362145874L);
		userBean.setEmail("manish@gmail.com");
		userBean.setPassword("Kunal#123");
		boolean status = dao.register(userBean);
		Assertions.assertTrue(status);
	}
}
