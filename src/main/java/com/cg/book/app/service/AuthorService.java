package com.cg.book.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.app.exception.AuthorNotFoundException;
import com.cg.book.app.model.Author;
import com.cg.book.app.repository.AuthorRepository;

//import com.cg.spring.boot.exception.AuthorNotFoundException;
//import com.cg.spring.boot.model.Author;
//import com.cg.spring.boot.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public List<Author> getAllAuthors() {
		LOG.info("getAllAuthors");
		return authorRepository.findAll();
	}

	public Author getAuthorById(int authorId) {
		Optional<Author> authorOptional = authorRepository.findById(authorId);
		Author author = null;
		if (authorOptional.isPresent()) {
			author = authorOptional.get();
			LOG.info(author.toString());
			return author;
		} else {
			String errorMessage = "Author with authorId " + authorId + " does not exist.";
			LOG.error(errorMessage);
			throw new AuthorNotFoundException(errorMessage);
		}
	}

	public Author addAuthor(Author author) {
		LOG.info(author.toString());
		return authorRepository.save(author);
	}

	public static void getAuthorByBookName(int authorId) {
		// TODO Auto-generated method stub
		
	}


}
