package com.tyss.hibernate_lms.service_test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.BorrowBook;
import com.tyss.hibernate_lms.service.StudentService;
import com.tyss.hibernate_lms.service.StudentServiceImplementation;

public class StudentServiceTest {
	
	StudentService studentService = new StudentServiceImplementation();

	@Test 
	public void testBookRequest() {
		int userId = 10003;
		int bookId = 1003;
		boolean status = studentService.bookRequest(userId, bookId);
		Assertions.assertTrue(status);
	}

	@Test
	public void testBorrowedBook() {
		int userId = 10000;
		List<BorrowBook> borrowBook = studentService.borrowedBook(userId);
		Assertions.assertNotNull(borrowBook);
	}

	@Test
	public void testSearchBookById() {
		int id = 2001;
		BookBean bookBean = studentService.searchBookById(id);
		Assertions.assertNotNull(bookBean);
	}

	@Test
	public void testSearchBookByTitle() {
		String bookTitle = "Antennas Propagation";
		BookBean bookBean = studentService.searchBookByTitle(bookTitle);
		Assertions.assertNotNull(bookBean);
	}

	@Test
	public void testSearchBookByAuthor() {
		String author = "Hall";
		BookBean bookBean = studentService.searchBookByAuthor(author);
		Assertions.assertNotNull(bookBean);
	}

	@Test
	public void testGetBooksInfo() {
		List<BookBean> bookBean = studentService.getBooksInfo();
		Assertions.assertNotNull(bookBean);
	}

	@Test
	public void testBookReturn() {
		int userId = 10002;
		int bookId = 2001;
		boolean status = studentService.bookReturn(userId, bookId);
		Assertions.assertTrue(status);
	}
}
