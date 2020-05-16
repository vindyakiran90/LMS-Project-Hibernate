package com.tyss.hibernate_lms.dao_test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.hibernate_lms.dao.AdminDAO;
import com.tyss.hibernate_lms.dao.AdminDAOImplementation;
import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.IssueBook;
import com.tyss.hibernate_lms.dto.RequestBook;
import com.tyss.hibernate_lms.dto.UserBean;

public class AdminDAOTest {

	private AdminDAO dao = new AdminDAOImplementation();

	@Test 
	public void testAddBook() { 
		BookBean bookBean = new BookBean();
		bookBean.setBookId(2000); 
		bookBean.setBookTitle("Antennas and Propagation");
		bookBean.setCategory("ECE"); 
		bookBean.setAuthor("Ramakrishna Janaswamy");
		bookBean.setNumberOfAvailableBooks(20); 
		bookBean.setNumberOfBooks(20);
		bookBean.setNumberOfIssuedBooks(1);
		bookBean.setPublisherName("IEEE Society"); 
		boolean status =  dao.addBook(bookBean);

		/*
		 * if(status) { System.out.println("Book added"); } else {
		 * System.out.println("Book not added"); }
		 */		
		Assertions.assertTrue(status); 
	}



	@Test 
	public void testDeleteBook() { 
		int bookId = 2001; 
		boolean status = dao.deleteBook(bookId); 
		Assertions.assertTrue(status); 
	}


	@Test 
	public void testIssueBook() { 
		int userId = 10001;
		int bookId = 2001; 
		boolean status = dao.issueBook(userId, bookId);
		Assertions.assertTrue(status); 
	}


	@Test public void testUpdateBook() { 
		String bookTitle = "Logic Design"; 
		int	numberOfBooks = 10;
		boolean status = dao.updateBook(bookTitle, numberOfBooks); 
		Assertions.assertTrue(status); 
	}

	@Test
	public void testShowRequest() {
		List<RequestBook> requestBooks = dao.showRequest();
		Assertions.assertNotNull(requestBooks);
	}

	@Test
	public void testShowStudentUsers() {
		List<UserBean> requestBooks = dao.showStudentUsers();
		Assertions.assertNotNull(requestBooks);
	}
	
	@Test
	public void testIssuedBooks() {
		List<IssueBook> issueBook = dao.issuedBooks();
		Assertions.assertNotNull(issueBook);
	}

	@Test
	public void testIsBookReceived() {
		int userId = 10002;
		int bookId = 1000;
		boolean status = dao.isBookReceived(userId, bookId);
		Assertions.assertTrue(status);
	}
}

