package com.microservices.microservicesproductservices.service;

import java.util.Date;
import java.util.List;
import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;
import com.microservices.microservicesproductservices.repository.ProductRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        
        if(productDB == null)
            return null;
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        productDB.setStatus("UPDATED");
        return productRepository.save(productDB);
    }
    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
    @Override
    public Product updateStock(Integer id, Double quantity) {
        Product productDB = getProduct(id);
        if(productDB == null)
            return null;
        Double stock = productDB.getStock()+quantity; 
        productDB.setStock(stock);
        return productRepository.save(productDB);
    }
    @Override
    public Product deleteProduct(Integer id) {
        Product productDB = getProduct(id);
        if(productDB == null)
            return null;
        productDB.setStatus("DELETED");
        return productRepository.save(productDB);
    }
}
