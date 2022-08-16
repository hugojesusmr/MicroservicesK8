package com.microservices.microservicesproductservices.controller;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.microservicesproductservices.entity.Category;
import com.microservices.microservicesproductservices.entity.Product;
import com.microservices.microservicesproductservices.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?> listProduct(
        @RequestParam(name = "categoryId", required = false) Long categoryId){
        List<Product> products = new ArrayList<>();

        if(categoryId == null){
            products = productService.listAllProduct();
            if(products.isEmpty())
                return ResponseEntity.noContent().build();  
        }else{
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if(products.isEmpty())
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        if(product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
        }
        Product productCreate = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }
 
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        Product productDB = productService.updateProduct(product);
        if(productDB == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Product productDelete = productService.deleteProduct(id);
        if(productDelete == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDelete);
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<?> updateStockProduct(@PathVariable Long id, @RequestParam(name = "quantity", required = true) Double quantity){
        Product product = productService.updateStock(id, quantity);

        if(product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    private String formatMessage(BindingResult result){
        List<Map<String, String>> errors = 
            result
                  .getFieldErrors()
                  .stream()
                  .map(
                      err -> {
                      Map<String, String> error = new HashMap<>();
                        error.put(err.getField(), err.getDefaultMessage());
                      return error;
                  }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                    .code("01")          
                    .message(errors).build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";

        try{
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }
}
