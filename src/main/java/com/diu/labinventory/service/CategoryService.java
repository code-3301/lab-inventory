package com.diu.labinventory.service;

import com.diu.labinventory.model.Category;
import com.diu.labinventory.repositpry.CategoryRepository;
import com.diu.labinventory.repositpry.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		if (!equipmentRepository.findByCategoryId(id).isEmpty()) {
			throw new IllegalStateException("Cannot delete category because it is associated with equipment.");
		}
		categoryRepository.deleteById(id);
	}
}