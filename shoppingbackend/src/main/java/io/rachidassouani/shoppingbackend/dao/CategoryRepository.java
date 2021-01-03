package io.rachidassouani.shoppingbackend.dao;

import java.util.List;

import io.rachidassouani.shoppingbackend.model.Category;

public interface CategoryRepository {

	void addCategory(Category category) throws Exception;
	
	void updateCategory(Category category) throws Exception;
	
	void deleteCategory(Category category) throws Exception;
	
	List<Category> findAllCategories();

	Category findCategory(String categoryCode);
	
}
