package com.lorram.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorram.library.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
