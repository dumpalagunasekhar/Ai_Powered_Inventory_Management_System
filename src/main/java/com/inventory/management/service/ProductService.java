
package com.inventory.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.management.entity.Product;
import com.inventory.management.exception.ResourceNotFoundException;
import com.inventory.management.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Product Not Found with id: " + id
                    )
                );
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateproduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Product Not Found with id: " + id
                    )
                );

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }

    public void deleteProductById(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Product Not Found with id: " + id
                    )
                );

        productRepository.delete(existingProduct);
    }
}
