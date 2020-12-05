package io.rachidassouani.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.rachidassouani.shoppingbackend.dto.CategoryDto;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static List<CategoryDto> categories = new ArrayList<CategoryDto>();
	
	static {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(1);
		categoryDto.setName("TV");
		categoryDto.setDescription("DEsc for TV");
		categoryDto.setImageURL("CAT_1.png");
		
		categories.add(categoryDto);
		
		CategoryDto categoryDto2 = new CategoryDto();
		categoryDto2.setId(2);
		categoryDto2.setName("MObile");
		categoryDto2.setDescription("DEsc for Mobile");
		categoryDto2.setImageURL("CAT_2.png");
		
		categories.add(categoryDto2);
	}
	
	@Override
	public List<CategoryDto> listCategories() {
		
		return categories;
	}

	@Override
	public CategoryDto getCategory(int categoryId) {
		for (CategoryDto categoryDto : categories) {
			if (categoryDto.getId() == categoryId) {
				return categoryDto;
			}
		}
		return null;
	}

}
