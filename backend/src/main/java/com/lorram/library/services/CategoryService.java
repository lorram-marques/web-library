package com.lorram.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lorram.library.dto.BookDTO;
import com.lorram.library.repositories.BookRepository;

@Service
public class CategoryService {

	@Autowired
	private BookRepository repository;
	
	public Page<BookDTO> findAll(Pageable pageable) {
		repository.findAll();
		return null; // TODO
	}
}
