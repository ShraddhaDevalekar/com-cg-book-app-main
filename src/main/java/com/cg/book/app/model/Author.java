package com.cg.book.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author_table")
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "authorId")
	private int authorId;

	@Column(name = "author_name")
	private String authorName;

	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Author [authorId = " + authorId + ", authorName = " + authorName + "]";
	}
	
	

}
