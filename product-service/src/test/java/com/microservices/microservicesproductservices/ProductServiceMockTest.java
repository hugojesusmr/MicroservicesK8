/* package com.microservices.microservicesproductservices;

import java.util.Date;
import java.util.Optional;

import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;
import com.microservices.microservicesproductservices.repository.CategoryRepository;
import com.microservices.microservicesproductservices.repository.ProductRepository;
import com.microservices.microservicesproductservices.service.ProductService;
import com.microservices.microservicesproductservices.service.ProductServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceMockTest {
    
    @Mock
    private ProductRepository productRepository;
    
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @BeforeEach
    public void setup(){

        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Category category = categoryRepository.findById(3).get();

        Product product = Product.builder()
            .id(1)
            .name("COMPUTER DESKTOP")
            .description("AMD RYZEN 3")
            .category(category)
            .stock(Double.parseDouble("10"))
            .price(Double.parseDouble("1234.67"))
            .status("Created")
            .createAt(new Date()).build();
        

        Mockito
               .when(productRepository.findById(1))
               .thenReturn(Optional.of(product));

        Mockito
               .when(productRepository.save(product))
               .thenReturn(product);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1);

        System.out.println(found);
    }
    @Test
    public void whenValidUpdateStock_TheReturnNewStock(){
        Product newStock = productService.updateStock(1, Double.parseDouble("8"));
        productRepository.save(newStock);
        System.out.println(newStock);     
    }
} */
