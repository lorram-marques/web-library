package com.lorram.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorram.library.dto.CategoryDTO;
import com.lorram.library.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {
		service.findAll(pageable);
		return null; // TODO
	}
}
