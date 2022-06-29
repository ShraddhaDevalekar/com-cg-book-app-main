package com.cg.book.app.exception;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String message) {
		super(message);
		logger.info(message);
	}
}
