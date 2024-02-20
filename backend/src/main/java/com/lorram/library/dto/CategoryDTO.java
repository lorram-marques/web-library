package com.lorram.library.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.lorram.library.entities.Book;
import com.lorram.library.entities.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	private Set<Book> books = new HashSet<>();
	
	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public CategoryDTO(Category category) {
		id = category.getId();
		name = category.getName();
		books = category.getBooks();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
