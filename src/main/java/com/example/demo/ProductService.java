package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo pr;
	
	public void adding(Product p){
		pr.save(p);
	}
	
	public List<Product> fetching() {
		return pr.findAll();
	}
	
	public Product fetchingId(Long id) {
		return pr.findById(id).orElse(null);
	}
	
	 public void deleteId(Long id) {
		 pr.deleteById(id);
		 
	 }
	 
	 public void updating(Product p) {
		 pr.save(p);
	 }
	 
	 public List<Product> lowStock(){
		 return pr.findByQuantityLessThan(10);
	 }
	 
	 public List<Product> highStock(){
		 return pr.findByQuantityGreaterThan(10);
	 }
	 
	 public List<Product> mousename() {
		 return pr.findByNameContainingIgnoreCase("Mouse");
	 }

	
	 public double getTotalInventoryValue() {
	     List<Product> all = pr.findAll();

	     double total = 0;

	     for (Product p : all) {
	         total += p.getPrice() * p.getQuantity();
	     }

	     return total;
	 }

}
