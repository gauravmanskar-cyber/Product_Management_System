package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	 List<Product> findByNameContainingIgnoreCase(String name);
	 
	 List<Product> findByQuantityLessThan(int qty);
	 
	 List<Product> findByQuantityGreaterThan(int qty);
	 
	 


}
