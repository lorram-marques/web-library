package com.lorram.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorram.library.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
