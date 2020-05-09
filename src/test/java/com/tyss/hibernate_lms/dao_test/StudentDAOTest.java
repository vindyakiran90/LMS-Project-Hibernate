package com.tyss.hibernate_lms.dao_test;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.hibernate_lms.dao.StudentDAO;
import com.tyss.hibernate_lms.dao.StudentDAOImplementation;
import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.BorrowBook;

public class StudentDAOTest {

	StudentDAO dao = new StudentDAOImplementation();
	
	@Test 
	public void testBookRequest() {
		int userId = 14001;
		int bookId = 2001;
		boolean status = dao.bookRequest(userId, bookId);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testBorrowedBook() {
		int userId = 14001;
		List<BorrowBook> borrowBook = dao.borrowedBook(userId);
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
		BorrowBook borrowBook1 = dao.bookBorrow(borrowBook);
		Assertions.assertNotNull(borrowBook1);
	}
	
	@Test
	public void testSearchBookById() {
		int id = 2001;
		BookBean bookBean = dao.searchBookById(id);
		Assertions.assertNotNull(bookBean);
	}
	
	@Test
	public void testSearchBookByTitle() {
		String bookTitle = "Antennas Propagation";
		BookBean bookBean = dao.searchBookByTitle(bookTitle);
		Assertions.assertNotNull(bookBean);
	}
	
	@Test
	public void testSearchBookByAuthor() {
		String author = "Hall";
		BookBean bookBean = dao.searchBookByAuthor(author);
		Assertions.assertNotNull(bookBean);
	}
	
	@Test
	public void testGetBooksInfo() {
		List<BookBean> bookBean = dao.getBooksInfo();
		Assertions.assertNotNull(bookBean);
	}
}
