package io.rachidassouani.shoppingbackend.dao;

import java.util.List;

import io.rachidassouani.shoppingbackend.model.Product;

public interface ProductRepository {

	// CRUD OPERATION
	Product findProductByCode(String productCode) throws Exception;
	List<Product> findAllProduct() throws Exception;
	void addProduct(Product product) throws Exception;
	void updateProduct(Product product) throws Exception;
	void deleteProduct(Product product) throws Exception;
	
	
	// BUSINESS METHODS
	List<Product> findAllActiveProducts() throws Exception;
	List<Product> findAllActiveProductsByCategory(long categoryId) throws Exception;
	List<Product> findLatestActiveProducts(int count) throws Exception;
	
	
	
}
