package com.tyss.hibernate_lms.dao;

import java.util.List;

import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.IssueBook;
import com.tyss.hibernate_lms.dto.RequestBook;
import com.tyss.hibernate_lms.dto.UserBean;

public interface AdminDAO {
	boolean addBook(BookBean bean);
	boolean deleteBook(int bookId);
	boolean issueBook(IssueBook bean);
	boolean updateBook(String bookTitle, int numberOfBooks);
	List<RequestBook> showRequest();
	List<UserBean> showUsers();
	boolean bookReturn(int userId, int bookId);
}
