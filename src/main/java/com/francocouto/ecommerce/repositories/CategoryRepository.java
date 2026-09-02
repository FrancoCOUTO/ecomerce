package com.francocouto.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francocouto.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
