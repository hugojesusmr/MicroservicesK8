package com.microservices.microservicesproductservices.service;

import java.util.List;

import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;

public interface ProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Integer id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Integer id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Integer id , Double quantity);
}
