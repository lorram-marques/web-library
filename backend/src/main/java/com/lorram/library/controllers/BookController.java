package com.lorram.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorram.library.dto.BookDTO;
import com.lorram.library.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService service;
	
	public ResponseEntity<Page<BookDTO>> findAll(Pageable pageable) {
		service.findAll(pageable);
		return null; // TODO
	}
}
