package io.rachidassouani.shoppingbackend.dao;

import java.util.List;

import io.rachidassouani.shoppingbackend.dto.CategoryDto;

public interface CategoryDao {

	public List<CategoryDto> listCategories();

	public CategoryDto getCategory(int categoryId);
}
