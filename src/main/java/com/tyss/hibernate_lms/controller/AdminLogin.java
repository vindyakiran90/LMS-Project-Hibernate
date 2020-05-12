package com.tyss.hibernate_lms.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.ValidationException;

import com.tyss.hibernate_lms.dto.BookBean;
import com.tyss.hibernate_lms.dto.IssueBook;
import com.tyss.hibernate_lms.dto.RequestBook;
import com.tyss.hibernate_lms.dto.UserBean;
import com.tyss.hibernate_lms.exception.CustomException;
import com.tyss.hibernate_lms.factory.AdminFactory;
import com.tyss.hibernate_lms.factory.RegisterationLoginFactory;
import com.tyss.hibernate_lms.factory.StudentFactory;
import com.tyss.hibernate_lms.service.AdminService;
import com.tyss.hibernate_lms.service.RegisterationLoginService;
import com.tyss.hibernate_lms.service.StudentService;
import com.tyss.hibernate_lms.validation.Validation;

public class AdminLogin {

	boolean flag = false;
	Validation validation = new Validation();
	AdminService adminService = AdminFactory.getAdminService();
	RegisterationLoginService registerationLoginService = RegisterationLoginFactory.getRegisterationLoginService();
	StudentService studentService = StudentFactory.getStudentService();

	public void login() {
		try(Scanner scanner = new Scanner(System.in);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
			do {
				try {
					System.out.println("Enter Email");
					String email = scanner.next();
					System.out.println("Enter Password");
					String password = scanner.next();
					if(validation.validateEmail(email) && validation.validatePassword(password)) {
						UserBean userBean = registerationLoginService.login(email, password);
						if(userBean.getRole().equals("Admin")) {
							System.out.println("Logged in");
							flag = true;
							while(flag) {
								System.out.println("Enter your choice");
								System.out.println("1:Add The Book \n"
										+ "2:Delete The Book \n"
										+ "3:Search The Book \n"
										+ "4:Update The Book \n"
										+ "5:Issue The Book \n"
										+ "6:Book List \n"
										+ "7:Student List \n"
										+ "8:Show Requests \n"
										+ "9:Book Return \n"
										+ "10:Issued Books List \n"
										+ "11:Go back to the Main");
								int choice1 = scanner.nextInt();

								switch(choice1) {
								case 1:
									BookBean bookBean = new BookBean();
									/*
									 * do { try { System.out.println("Enter the book id"); int bookId =
									 * scanner.nextInt(); if(validation.validateBookId(bookId)) {
									 * bookBean.setBookId(bookId); flag = true; } } catch (InputMismatchException e)
									 * { flag = false; System.err.println("Enter the book Id as digits"); } catch
									 * (ValidationException e) { flag = false; System.err.println(e.getMessage()); }
									 * }while(!flag);
									 */

									do {
										try {
											System.out.println("Enter the book title");
											String bookName = bufferedReader.readLine(); 
											if(validation.validateBook(bookName)) {
												bookBean.setBookTitle(bookName);
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the booktitle");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									do {
										try {
											System.out.println("Enter the author name");
											String authorName = bufferedReader.readLine(); 
											if(validation.validateBook(authorName)) {
												bookBean.setAuthor(authorName);
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Invalid author name");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									do {
										try {
											System.out.println("Enter the category name");
											String category = bufferedReader.readLine(); 
											if(validation.validateBook(category)) {
												bookBean.setCategory(category);
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the category");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									do {
										try {
											System.out.println("Enter the book copies");
											int numberOfBooks = scanner.nextInt();
											if(validation.validateCopies(numberOfBooks)) {
												bookBean.setNumberOfBooks(numberOfBooks);
												bookBean.setNumberOfAvailableBooks(numberOfBooks);
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the book copies");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									do {
										try {
											System.out.println("Enter the book publisher name");
											String publisher = bufferedReader.readLine();
											if(validation.validateBook(publisher)) {
												bookBean.setPublisherName(publisher);
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Invalid publisher name");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(adminService.addBook(bookBean)) {
										System.out.println("Book added successfully");
									} else {
										System.out.println("Book copies is updated");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 2:
									System.out.println("Enter the book id"); 
									int bookId = scanner.nextInt(); 
									do { 
										try { 
											if(validation.validateBookId(bookId)) {
												flag = true; 
											} 
										} catch (InputMismatchException e) { 
											flag = false; 
											System.err.println("Enter the book Id as digits"); 
										} catch (ValidationException e) { 
											flag = false; 
											System.err.println(e.getMessage()); 
										}
									}while(!flag);

									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(adminService.deleteBook(bookId)) {
										System.out.println("Book deleted successfully");
									} else {
										System.out.println("Book deletion is unsuccessful");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 3:
									BookBean bookBean1 = new BookBean();
									System.out.println("Enter your choice");
									System.out.println("1:Search Book By Title \t 2:Search book By Author");
									int ch = scanner.nextInt();
									switch(ch) {
									case 1:
										System.out.println("Enter the book title");
										String bookTitle = bufferedReader.readLine();
										do {
											try {
												if(validation.validateBook(bookTitle)) {
													flag = true;
												}
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Enter the booktitle");
											} catch (ValidationException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										}while(!flag);

										bookBean1 = studentService.searchBookByTitle(bookTitle);
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");										
										if(bookBean1 != null) {
											System.out.println("Book is available");
										} else {
											System.out.println("Book is not available");
										}
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										break;
									case 2:
										System.out.println("Enter the book author");
										String author = bufferedReader.readLine();
										do {
											try {
												if(validation.validateBook(author)) {
													flag = true;
												}
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Invalid author name");
											} catch (ValidationException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										}while(!flag);

										bookBean1 = studentService.searchBookByAuthor(author);
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										if(bookBean1 != null) {
											System.out.println("Book is available");
										} else {
											System.out.println("Book is not available");
										}
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										break;
									default:
										throw new CustomException("Invalid choice");
									}//End of switch case		
									break;
								case 4:
									System.out.println("Enter the book title");
									String bookTitle = bufferedReader.readLine();
									do {
										try {
											if(validation.validateBook(bookTitle)) {
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the booktitle");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);


									System.out.println("Enter the copies to update");
									int copies = scanner.nextInt(); 
									do {
										try {
											if(validation.validateCopies(copies)) {
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the book copies");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(adminService.updateBook(bookTitle, copies)) {
										System.out.println("Updated book copies successfully");
									} else {
										System.out.println("Not updated");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 5:
									System.out.println("Enter the Student User Id");
									int user_Id2 = scanner.nextInt();

									do {
										try {
											if(validation.validateId(user_Id2)) {
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Invalid User Id");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									
									System.out.println("Enter the Book Id");
									int book_Id2 = scanner.nextInt();
									do {
										try {
											if(validation.validateBookId(book_Id2)) {
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter the book Id as digits");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									boolean check = adminService.issueBook(user_Id2, book_Id2);

									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(check) {
										System.out.println("Book issued successfully");
									} else {
										System.out.println("Book is not issued");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 6:
									List<BookBean> allBookInfo = studentService.getBooksInfo();
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(!allBookInfo.isEmpty()) {
										System.out.println(String.format("%-10s %-15s %-15s %-15s %-15s %-20s %-20s %-20s", 
												"BOOK ID", "BOOK TITLE", "CATEGORY", "AUTHOR", "PUBLISHER NAME", "NUMBER OF BOOKS", 
												"NUMBER OF AVAILABLE BOOKS", "NUMBER OF ISSUED BOOKS"));
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										System.out.println();
										for(BookBean beanInfo : allBookInfo) {
											System.out.println(beanInfo.toString());
										}
									} else {
										System.out.println("No books are available");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 7:
									List<UserBean> studentInfo = adminService.showStudentUsers();
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(!studentInfo.isEmpty() ) {
										System.out.println(String.format("%-10s %-15s %-15s %-10s %-12s %-20s %-10s", "USER ID", "FIRST NAME", 
												"LAST NAME", "ROLE", "PHONE NO", "EMAIL", "PASSWORD"));
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										System.out.println();
										for(UserBean beanInfo : studentInfo) {
											System.out.println(beanInfo.toString());
										}
									} else {
										System.out.println("No students are available");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 8:
									List<RequestBook> requestBook = adminService.showRequest();
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(!requestBook.isEmpty()) {
										System.out.println(String.format("%-10s %-10s %-10s %-15s %-15s %-10s", "REQUEST ID", 
												"USER ID", "BOOK ID", "FIRST NAME", "LAST NAME", "BOOK TITLE"));
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										System.out.println();
										for(RequestBook requestBook2: requestBook) {
											System.out.println(requestBook2.toString());
										}
									} else {
										System.out.println("No requests are available");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 9:
									System.out.println("Enter User Id");
									int user_Id = scanner.nextInt();

									do { 
										try { 
											if(validation.validateId(user_Id)) { 
												flag = true; 
											} 
										} catch	(InputMismatchException e) { 
											flag = false;
											System.err.println("Invalid User Id"); 
										} catch (ValidationException e) { 
											flag = false; 
											System.err.println(e.getMessage()); 
										} 
									}while(!flag);


									System.out.println("Enter Book Id");
									int book_Id = scanner.nextInt();
									do {
										try {
											if(validation.validateBookId(book_Id)) {
												flag = true;
											}
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Invalid Book Id");
										} catch (ValidationException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									}while(!flag);

									boolean status = adminService.bookReturn(user_Id, book_Id);
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(status) {
										System.out.println("Book returned successfully");
									} else {
										System.out.println("Unable to return the book");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;

								case 10:
									List<IssueBook> issueBook = adminService.issuedBooks();
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									if(!issueBook.isEmpty() ) {
										System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s", "ISSUE ID", "BOOK ID", "ISSUE DATE", "RETURN DATE", "USER ID"));
										System.out.println("----------------------------------------------------------------------------------------"
												+ "---------------------------------------------------------------------------------------------");
										System.out.println();
										for(IssueBook issueBook1 : issueBook) {
											System.out.println(issueBook1.toString());
										}
									} else {
										System.out.println("No books are issued");
									}
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									break;
								case 11:
									System.out.println("----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------");
									String args[] = {"Welcome to Main Controller"}; 
									MainController.main(args);	
									break;
								default:
									throw new CustomException("Invalid choice");
								}//End of Switch case
							}//End of While loop
						} else {
							System.out.println("Not an Admin");
						}
					} else {
						System.out.println("Invalid Email/Password");
					}
				} catch(Exception e) {
					flag = false;
					System.out.println("Invalid Email/Password");
				}
			} while(!flag);

		} catch (IOException e1) {
			System.out.println("Invalid Input");
		}
	}
}
