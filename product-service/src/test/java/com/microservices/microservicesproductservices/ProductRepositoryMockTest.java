/* package com.microservices.microservicesproductservices;

import java.util.Date;
import java.util.List;

import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;
import com.microservices.microservicesproductservices.repository.CategoryRepository;
import com.microservices.microservicesproductservices.repository.ProductRepository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryMockTest {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void testCreateNewProductAndAssingCategoryExisting(){
        Category category = categoryRepository.findById(3).get();

        Product product = Product.builder()
            .name("COMPUTER DESKTOP")
            .description("AMD RYZEN 3")
            .category(category)
            .stock(Double.parseDouble("10"))
            .price(Double.parseDouble("1234.67"))
            .status("Created")
            .createAt(new Date()).build();
        
            productRepository.save(product);

        List<Product> founds = productRepository.findByCategory(product.getCategory());

        
        founds
           .stream()
           .forEach(System.out::println);

    }

    
}
 */