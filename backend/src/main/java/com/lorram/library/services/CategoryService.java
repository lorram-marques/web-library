package com.lorram.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lorram.library.dto.CategoryDTO;
import com.lorram.library.entities.Category;
import com.lorram.library.repositories.CategoryRepository;
import com.lorram.library.services.exceptions.DatabaseException;
import com.lorram.library.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Page<CategoryDTO> findAll(PageRequest pageRequest) {
		Page<Category> list = repository.findAll(pageRequest);
		return list.map(x -> new CategoryDTO(x));
	}
	
	public CategoryDTO findById(Long id) {
		Optional<Category> book = repository.findById(id);
		Category entity = book.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CategoryDTO(entity);
	}
	
	public CategoryDTO update(CategoryDTO dto, Long id) {
		Category entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		try {
			fromDto(dto, entity);
			entity = repository.save(entity);
			} catch(DataIntegrityViolationException e) {
				throw new DatabaseException("Integrity violation");
			}
		return new CategoryDTO(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);;
	}
	
	private void fromDto(CategoryDTO dto, Category entity) {
		entity.setName(dto.getName());
	}
}
