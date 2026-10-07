package com.inventory.management.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.inventory.management.entity.*;
import com.inventory.management.service.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/search")
	public String searchProduct(@RequestParam String name) {
		return "Searching for: " + name;
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public String addProducts(@RequestBody Product product) {
		
		productService.addProduct(product);
		return "Product recived";
	}
	
	@PutMapping
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateproduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		
		return "Product Deleted Successfully";
	}
	
} 
 	