package com.practice.Spring.boot.practice.error;

public class BookNotFoundException extends Exception {

	public BookNotFoundException() {
		super();
	}
	public BookNotFoundException(String message) {
		super(message);
	}
	public BookNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
	public BookNotFoundException(Throwable cause) {
		super(cause);
	}
	/*
	public BookNotFoundException(String message, Throwable cause,Suppress) {
		super(message,cause);
	}*/
	
}
