package com.tyss.hibernate_lms.service_test;

import java.time.LocalDate;
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
	public void testBookBorrow() {
		BorrowBook borrowBook = new BorrowBook();
		borrowBook.setBookId(2001);
		borrowBook.setUserId(10002);
		borrowBook.setNoOfBooksBorrowed(1);
		borrowBook.setDateOfBorrowed(LocalDate.now());
		borrowBook.setDateOfReturn(LocalDate.now().plusDays(10));
		borrowBook.setFees(0.0);
		BorrowBook borrowBook1 = studentService.bookBorrow(borrowBook);
		Assertions.assertNotNull(borrowBook1);
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

}
