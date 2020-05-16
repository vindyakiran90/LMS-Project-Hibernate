package com.tyss.hibernate_lms.service;

import java.util.List;

import com.tyss.hibernate_lms.dao.AdminDAO;
import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.IssueBook;
import com.tyss.hibernate_lms.dto.RequestBook;
import com.tyss.hibernate_lms.dto.UserBean;
import com.tyss.hibernate_lms.factory.AdminFactory;

public class AdminServiceImplementation implements AdminService {

	AdminDAO dao = AdminFactory.getAdminDAO();

	@Override
	public boolean addBook(BookBean bean) {
		return dao.addBook(bean);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public boolean issueBook(int userId, int bookId) {
		return dao.issueBook(userId, bookId);
	}

	@Override
	public boolean updateBook(String bookTitle, int numberOfBooks) {
		return dao.updateBook(bookTitle, numberOfBooks);
	}

	@Override
	public List<RequestBook> showRequest() {
		return dao.showRequest();
	}

	@Override
	public List<UserBean> showStudentUsers() {
		return dao.showStudentUsers();
	}

	@Override
	public List<IssueBook> issuedBooks() {
		return dao.issuedBooks();
	}

	@Override
	public boolean isBookReceived(int userId, int bookId) {
		return dao.isBookReceived(userId, bookId);
	}
}
