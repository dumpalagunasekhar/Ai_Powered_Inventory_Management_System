package com.inventory.management.service;

import org.springframework.stereotype.Service;

import com.inventory.management.entity.Product;
import com.inventory.management.repository.ProductRepository;
import java.util.*;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public void addProduct(Product product) {
		
		System.out.println("Product name: "+product.getName());
		System.out.println("Price :"+ product.getPrice());
		System.out.println("Quantity: "+ product.getQuantity());
		
		productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product updateproduct(Long id, Product product) {
		Product existingProduct =  productRepository.findById(id).orElse(null);
		if(existingProduct == null) {
			return null;
		}
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(existingProduct);
		
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
}
