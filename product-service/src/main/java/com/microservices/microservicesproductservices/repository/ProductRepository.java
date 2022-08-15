package com.microservices.microservicesproductservices.repository;

import java.util.List;

import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    public List<Product> findByCategory(Category category);
}
