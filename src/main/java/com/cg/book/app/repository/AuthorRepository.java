package com.cg.book.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.book.app.model.Author;

//import com.cg.spring.project.book.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	List<Author> findAll();

	Author save(Author author);

	Optional<Author> findById(int authorId);

}