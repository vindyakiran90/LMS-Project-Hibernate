package com.tyss.hibernate_lms.service_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.hibernate_lms.dto.UserBean;
import com.tyss.hibernate_lms.service.RegisterationLoginService;
import com.tyss.hibernate_lms.service.RegisterationLoginServiceImplementation;

public class RegisterationLoginServiceTest {
	
	private RegisterationLoginService registerationLoginService = new RegisterationLoginServiceImplementation();
	
	@Test
	public void loginTest() {
		String email = "kushi@gmail.com";
		String password = "Lavana456@";
		UserBean userBean = registerationLoginService.login(email, password);
		Assertions.assertNotNull(userBean);
	}
	
	@Test
	public void registerTest() {
		UserBean userBean = new UserBean();
		userBean.setUserId(10003);
		userBean.setFirstName("Manu");
		userBean.setLastName("Manju");
		userBean.setRole("Student");
		userBean.setPhoneNo(9362149674L);
		userBean.setEmail("manu@gmail.com");
		userBean.setPassword("Kumar#123");
		boolean status =registerationLoginService.register(userBean);
		Assertions.assertTrue(status);
	}


	
}
