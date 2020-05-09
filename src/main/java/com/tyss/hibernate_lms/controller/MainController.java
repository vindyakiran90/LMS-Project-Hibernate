package com.tyss.hibernate_lms.controller;

import java.util.Scanner;

public class MainController {

	public static void main(String[] args) {

		while(true) {
			System.out.println("----------------------------------------------------------------------------------------"
					+ "---------------------------------------------------------------------------------------------");
			System.out.println("                                                                        Welcome to Library Management System");
			System.out.println("----------------------------------------------------------------------------------------"
					+ "---------------------------------------------------------------------------------------------");
			System.out.println("Enter your choice \n1:Student Login    2:Admin Login   3:Registeration");
			Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					StudentLogin studentLogin = new StudentLogin();
					studentLogin.login();	
					break;
				case 2:
					AdminLogin adminLogin = new AdminLogin();
					adminLogin.login();
					break;
				case 3:
					Registeration registeration = new Registeration();
					registeration.register();
					break;
				default:System.out.println("Invalid entry");
				scanner.close();
			}
		}
	}
}
