package com.sethjava.springdata.repository.postgres;


import com.sethjava.springdata.model.postgres.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
