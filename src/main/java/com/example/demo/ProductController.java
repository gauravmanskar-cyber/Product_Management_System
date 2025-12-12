package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService ps;

	 @GetMapping("/")
	 public ResponseEntity<?> Test() {
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Tested Ok");
		 
	 }
	 
	 @PostMapping("/add")
	 public ResponseEntity<?> adding(@RequestBody Product p){
		 try {
			 ps.adding(p);
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product Adding Succesfully");
		 }catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		 }
	 }
	 
	 @GetMapping("/fetch")
	 public ResponseEntity<List<Product>> fetching(){
		 
		 try {
			 List<Product> p  = ps.fetching();
			 return ResponseEntity.ok(p);
					 
		 }catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
	 }
	 
	 @GetMapping("/fetch/{id}")
	 public ResponseEntity<Product> FetchingId(@PathVariable Long id){
		 Product p = ps.fetchingId(id);
		 
		 if(p == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 
		 return ResponseEntity.ok(p);
		 
	 }
	
	 @GetMapping("/delete/{id}")
	 public ResponseEntity<?> deleteId(@PathVariable Long id){
		  ps.deleteId(id);
		 
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product deleted Successfully");
	 }
	 
	 @PostMapping("/update")
	 public ResponseEntity<?> updating(@RequestBody Product p){
		  
		try {
			 ps.updating(p);
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updating successfully");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
		}
	 }
	 
	 
	 @GetMapping("/low-stock")
	 public ResponseEntity<List<Product>> lowStock(){
		 List<Product> data = ps.lowStock();
		 return ResponseEntity.ok(data);
	 }
	 
	 @GetMapping("/high-stock")
	 public ResponseEntity<List<Product>> highStock(){
		List<Product> data = ps.highStock();
		 return ResponseEntity.ok(data);
	 }
	 
	 @GetMapping("/name=mouse")
	 public ResponseEntity<List<Product>> namemouse(){
		 List<Product> data = ps.mousename();
		 return ResponseEntity.ok(data);
	 }
	 
	 
	 @GetMapping("/total-value")
	 public ResponseEntity<Double> totalValue() {
	     double total = ps.getTotalInventoryValue();
	     return ResponseEntity.ok(total);
	 }

	 
	 
}
