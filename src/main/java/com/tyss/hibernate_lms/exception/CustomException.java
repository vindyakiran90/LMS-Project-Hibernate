package com.tyss.hibernate_lms.exception;

public class CustomException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7525093754101555270L;

	public CustomException(String msg) {
		super(msg);
	}
}
