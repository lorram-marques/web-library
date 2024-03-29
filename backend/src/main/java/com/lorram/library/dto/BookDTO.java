package com.lorram.library.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.lorram.library.entities.Book;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String author;
	
	private Set<CategoryDTO> categories = new HashSet<>();

	public BookDTO() {
	}

	public BookDTO(Long id, String title, String author, Set<CategoryDTO> categories) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.categories = categories;
	}
	
	public BookDTO(Book book) {
		id = book.getId();
		title = book.getTitle();
		author = book.getAuthor();
		categories = book.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDTO> categories) {
		this.categories = categories;
	}
}
