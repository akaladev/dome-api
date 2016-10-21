package com.dome.base.application.exception;

/**
 * Application exception.
 * 
 * @author Michael Akala
 */
public class ApplicationException extends RuntimeException {

	/** Serial version UID */
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
