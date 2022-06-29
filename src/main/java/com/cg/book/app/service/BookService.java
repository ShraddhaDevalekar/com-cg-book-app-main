package com.cg.book.app.service;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.app.exception.BookNotFoundException;
import com.cg.book.app.model.Book;
import com.cg.book.app.repository.AuthorRepository;
import com.cg.book.app.repository.BookRepository;

//import com.cg.spring.project.book.exception.BookNotFoundException;
//import com.cg.spring.project.book.model.Book;
//import com.cg.spring.project.book.repository.AuthorRepository;
//import com.cg.spring.project.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	AuthorService  authorService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public List<Book> getAllBooks() {
		LOG.info("getAllBooks");
		return bookRepository.findAll();
	}

	public Book getBookById(int bookId) {
		Optional<Book> bookOptional = bookRepository.findBookById(bookId);
		Book book = null;
		if (bookOptional.isPresent()) {
			book = bookOptional.get();
			LOG.info(book.toString());
			return book;
		} else {
			String errorMessage = "Book with id " + bookId + " does not exist.";
			LOG.error(errorMessage);
			throw new BookNotFoundException(errorMessage);
		}
	}

//	public List<Book> getBookByName(String Name) {
//		LOG.info(Name);
//		//List<Book> bookList = bookRepository.findByNameIgnoreCase(bookName);
//		if (null != bookList)
//			return bookList;
//		String errorMessage = "Book with Name " + Name + " does not exist.";
//		throw new BookNotFoundException(errorMessage);
//	}

	public Book addBook(Book book) {
		LOG.info(book.toString());
		if (book.getAuthor() != null)

			AuthorService.getAuthorByBookName(book.getAuthor().getAuthorId());

		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		LOG.info(book.toString());
		this.getBookById(book.getBookId());

		return bookRepository.save(book);
	}

//	public Book deleteBook(int bookId) {
//		LOG.info(Integer.toString(bookId));
//		Book bookToDelete = this.getBookById(bookId);
//		bookRepository.delete(bookToDelete);
//		return bookToDelete;
//	}

}