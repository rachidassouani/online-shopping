package io.rachidassouani.shoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.rachidassouani.shoppingbackend.model.Product;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product findProductByCode(String productCode) throws Exception {
		String sqlQuery = "FROM Product p WHERE p.code = :productCode";
		
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(sqlQuery, Product.class);
		query.setParameter("productCode", productCode);
		
		return query.getSingleResult();
			
	}

	@Override
	public List<Product> findAllProduct() throws Exception {	
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public void addProduct(Product product) throws Exception {
		sessionFactory.getCurrentSession().persist(product);
		
	}
	
	@Override
	public void updateProduct(Product product) throws Exception {
		sessionFactory.getCurrentSession().update(product);
		
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		product.setActive(false);
		this.updateProduct(product);
		
	}

	@Override
	public List<Product> findAllActiveProducts() throws Exception {
		Query<Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = :active", Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> findAllActiveProductsByCategory(long categoryId) throws Exception {
		final String findAllActiveProductsByCategoryQuery = "FROM Product WHERE active = :active AND categoryId = :categoryId"; 
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(findAllActiveProductsByCategoryQuery, Product.class);
		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> findLatestActiveProducts(int count) throws Exception {
		final String findLatestActiveProductsQuery = "FROM Product WHERE active = :active ORDER BY id DESC";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(findLatestActiveProductsQuery, Product.class);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
		
	}

	

	

}
