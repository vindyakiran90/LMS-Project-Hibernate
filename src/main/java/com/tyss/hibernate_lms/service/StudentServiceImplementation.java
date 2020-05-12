package com.tyss.hibernate_lms.service;

import java.util.List;

import com.tyss.hibernate_lms.dao.StudentDAO;
import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.BorrowBook;
import com.tyss.hibernate_lms.factory.StudentFactory;

public class StudentServiceImplementation implements StudentService {

	private StudentDAO dao = StudentFactory.getStudentDAO();

	@Override
	public boolean bookRequest(int userId, int bookId) {
		return dao.bookRequest(userId, bookId);
	}

	@Override
	public List<BorrowBook> borrowedBook(int userId) {
		return dao.borrowedBook(userId);
	}

	@Override
	public BookBean searchBookById(int bookId) {
		return dao.searchBookById(bookId);
	}

	@Override
	public BookBean searchBookByTitle(String bookTitle) {
		return dao.searchBookByTitle(bookTitle);
	}

	@Override
	public BookBean searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public List<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}
}
