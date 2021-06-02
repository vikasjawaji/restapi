package com.employee.exception;

public class EmployeeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7475257451378348746L;
	
	private String msg;
	public EmployeeException(String msg) {
		this.msg= msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
