package com.example.suntestmvc.repository;

import com.example.suntestmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
