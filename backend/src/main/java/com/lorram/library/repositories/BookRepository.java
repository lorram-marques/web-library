package com.lorram.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorram.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
