package io.rachidassouani.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rachidassouani.shoppingbackend.dao.ProductRepository;
import io.rachidassouani.shoppingbackend.model.Product;

@RestController
@RequestMapping("api/products")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> findAllProducts() throws Exception {
		return productRepository.findAllActiveProducts();
	}
	
}
