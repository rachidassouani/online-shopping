package io.rachidassouani.shoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.rachidassouani.shoppingbackend.model.Category;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> findAllCategories() {

		String selectActiveCategories = "FROM Category WHERE active = :active";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories, Category.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Category findCategory(String categoryCode) {
		//return sessionFactory.getCurrentSession().get(Category.class, categoryCode);
		Query<Category> query = sessionFactory.getCurrentSession().createQuery("FROM Category WHERE code = :code", Category.class);
		query.setParameter("code", categoryCode);
		return query.getSingleResult();
	}

	
	@Override
	public void addCategory(Category category) throws Exception {
		sessionFactory.getCurrentSession().persist(category);
		
	}

	@Override
	public void updateCategory(Category category) throws Exception {
		sessionFactory.getCurrentSession().update(category);	
	}

	@Override
	public void deleteCategory(Category category) throws Exception {
		
		category.setActive(false);
		this.updateCategory(category);
	}

}
