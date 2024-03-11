package com.lorram.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lorram.library.dto.BookDTO;
import com.lorram.library.dto.CategoryDTO;
import com.lorram.library.entities.Book;
import com.lorram.library.entities.Category;
import com.lorram.library.repositories.BookRepository;
import com.lorram.library.repositories.CategoryRepository;
import com.lorram.library.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<BookDTO> findAll(Long categoryId, PageRequest pageRequest) {
		if(categoryId == 0) {
			Page<Book> list = repository.findAll(pageRequest);
			return list.map(x -> new BookDTO(x));
		} else {
			List<Book> list = categoryRepository.getReferenceById(categoryId).getBooks();
			Page<Book> page = new PageImpl<>(list, pageRequest, list.size());
			return page.map(x -> new BookDTO(x));
		}
	}
	
	public BookDTO findById(Long id) {
		Optional<Book> book = repository.findById(id);
		Book entity = book.orElseThrow(() -> new ResourceNotFoundException(id));
		return new BookDTO(entity);
	}
	
	public BookDTO update(BookDTO dto, Long id) {
		Book entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new BookDTO(entity);
	}
	
	public BookDTO insert(BookDTO dto) {
		Book entity = new Book();
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new BookDTO(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);;
	}
	
	private void fromDto(BookDTO dto, Book entity) {
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getAuthor());
		
		entity.getCategories().clear();
		for (CategoryDTO categoryDto : dto.getCategories()) {
			Category category = categoryRepository.getReferenceById(categoryDto.getId());
			entity.getCategories().add(category);			
		}
	}
}
