package com.tyss.hibernate_lms.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="borrowBook")
@SequenceGenerator(name="generator3", initialValue = 1, allocationSize = 200)
public class BorrowBook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5905964161779021200L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "generator3")
	private int borrowId;
	@Column
	private int bookId;
	@Column
	private int userId;
	@Column
	private int noOfBooksBorrowed;
	@Column
	private LocalDate dateOfBorrowed;
	@Column
	private LocalDate dateOfReturn;
	@Column
	private double fees;
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-20s %-20s %-20s %-10s", borrowId, userId, bookId, noOfBooksBorrowed, 
				dateOfBorrowed, dateOfReturn, fees);
	}
}
