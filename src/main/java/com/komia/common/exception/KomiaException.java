package com.komia.common.exception;

public class KomiaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public KomiaException() {
		super();
	}

	public KomiaException(String message, Throwable cause) {
		super(message, cause);
	}

	public KomiaException(String message) {
		super(message);
	}

	public KomiaException(Throwable cause) {
		super(cause);
	}
	
}
