package com.lorram.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorram.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
