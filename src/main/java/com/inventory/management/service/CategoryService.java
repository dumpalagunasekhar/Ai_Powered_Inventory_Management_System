package com.inventory.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.management.entity.Category;
import com.inventory.management.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Long id) {
		
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category updateCategory(Long id, Category category) {
		Category existingCategory = categoryRepository.findById(id).orElse(null);
		
		if(existingCategory == null) {
			return null;
		}
		
		existingCategory.setName((category.getName()));
		existingCategory.setDescription(category.getDescription());
		
		return categoryRepository.save(existingCategory);
		
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
