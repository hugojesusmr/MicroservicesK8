package com.microservices.repository;

import java.util.List;

import com.microservices.entity.Category;
import com.microservices.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public List<Product> findByCategory(Category category);
}
