package com.vtworks.moviesphere.core.exception;

public class MovieSphereException extends Exception {
	int errorCode;
	int errorObjectID;
	private static final long serialVersionUID = 1L;

	public MovieSphereException() {
		super();
	}

	public MovieSphereException(String message) {
		super(message);
	}

	public MovieSphereException(Exception e) {
		super(e);
	}

	public MovieSphereException(String message, Exception e) {
		super(message, e);
	}

	public MovieSphereException(int errCode, Exception e) {
		super(e);
	}

	public MovieSphereException(int errCode, String message, Exception e) {
		super(message, e);
		errorCode = errCode;
	}

	public MovieSphereException(int errCode, String message) {
		super(message);
		errorCode = errCode;
	}
}
