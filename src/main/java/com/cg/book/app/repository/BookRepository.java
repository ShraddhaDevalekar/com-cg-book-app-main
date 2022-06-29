package com.cg.book.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.book.app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public abstract Optional<Book> findById(int bookId);

	public abstract List<Book> findByBookName(String bookName);

	public abstract List<Book> findByAuthorName(String author);

	public abstract List<Book> findByCategory(String category);

	public abstract List<Book> findByRating(int rating);

	public abstract List<Book> findByNameIgnoreCase(String bookName);

	public abstract List<com.cg.book.app.model.Book> findAll();

	//public abstract Optional<Book> findBookById(int bookId);

	public abstract Optional<com.cg.book.app.model.Book> findBookById(int bookId);

	//public abstract com.cg.book.app.model.Book save(com.cg.book.app.model.Book book);

	//public abstract void delete(com.cg.book.app.model.Book bookToDelete);
}