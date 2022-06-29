package com.cg.book.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.app.model.Author;
import com.cg.book.app.service.AuthorService;



@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	// http://localhost:9999/author/get-all-authors
	@GetMapping("/get-all-authors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authorList = authorService.getAllAuthors();
		for (Author author : authorList)
			LOG.info(author.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Author>> response = new ResponseEntity<>(authorList, status);
		return response;
	}

	// http://localhost:9999/author/get-author-by-id/{authorId}
	@GetMapping("/get-author-by-id/{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(name = "authorId") int authorId) {
		LOG.info(Integer.toString(authorId));
		Author author = authorService.getAuthorById(authorId);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Author> response = new ResponseEntity<>(author, status);
		return response;
	}

	// http://localhost:9999/author/add-author
	@PostMapping("/add-author")
	public Author addAuthor(@RequestBody Author author) {
		LOG.info(author.toString());
		return authorService.addAuthor(author);
	}

}
