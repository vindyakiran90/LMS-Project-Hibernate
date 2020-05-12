package com.tyss.hibernate_lms.service;

import java.util.List;

import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.IssueBook;
import com.tyss.hibernate_lms.dto.RequestBook;
import com.tyss.hibernate_lms.dto.UserBean;

public interface AdminService {
	
	boolean addBook(BookBean bean);
	boolean deleteBook(int bookId);
	boolean issueBook(int userId, int bookId);
	boolean updateBook(String bookTitle, int numberOfBooks);
	List<RequestBook> showRequest();
	List<UserBean> showStudentUsers();
	List<IssueBook> issuedBooks();
	boolean bookReturn(int userId, int bookId);
}
