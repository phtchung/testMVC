package com.example.suntestmvc.service;

import com.example.suntestmvc.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    void addProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
