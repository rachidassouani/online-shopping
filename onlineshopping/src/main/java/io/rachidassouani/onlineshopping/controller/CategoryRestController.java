package io.rachidassouani.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rachidassouani.shoppingbackend.dao.CategoryRepository;
import io.rachidassouani.shoppingbackend.dao.ProductRepository;
import io.rachidassouani.shoppingbackend.model.Category;
import io.rachidassouani.shoppingbackend.model.Product;

@RestController
@RequestMapping("api/categories")
public class CategoryRestController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("{categoryCode}/products")
	public List<Product> findAllProductsByCategory(@PathVariable String categoryCode) throws Exception {
		Category category = categoryRepository.findCategory(categoryCode);
		List<Product> products = new ArrayList<Product>();
		if (category != null) {
			products = productRepository.findAllActiveProductsByCategory(category.getId());
		}
		return products;
	}
}
