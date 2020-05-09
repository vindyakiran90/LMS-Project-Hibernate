package com.tyss.hibernate_lms.factory;

import com.tyss.hibernate_lms.dao.StudentDAO;
import com.tyss.hibernate_lms.dao.StudentDAOImplementation;
import com.tyss.hibernate_lms.service.StudentService;
import com.tyss.hibernate_lms.service.StudentServiceImplementation;

public class StudentFactory {

	public static StudentDAO getStudentDAO() {
		return new StudentDAOImplementation();
	}
	public static StudentService getStudentService() {
		return new StudentServiceImplementation();
	}
}
