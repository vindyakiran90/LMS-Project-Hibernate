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
@Table(name="issueBook")
@SequenceGenerator(name="generator4", initialValue = 1, allocationSize = 200)
public class IssueBook implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8039576523218094099L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "generator4")
	private int issueId;
	@Column
	private int bookId;
	@Column
	private int userId;
	@Column
	private LocalDate issueDate;
	@Column
	private LocalDate returnDate;
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s", issueId, bookId, issueDate, returnDate, userId);
	}
}
