package com.tyss.hibernate_lms.service;

import java.util.List;

import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.BorrowBook;

public interface StudentService {
	boolean bookRequest(int userId, int bookId);
	List<BorrowBook> borrowedBook(int userId);
	BookBean searchBookById(int bookId);
	BookBean searchBookByTitle(String bookTitle);
	BookBean searchBookByAuthor(String author);
	List<BookBean> getBooksInfo();
	boolean bookReturn(int userId, int bookId);
}
