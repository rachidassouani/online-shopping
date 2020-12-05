package io.rachidassouani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.rachidassouani.shoppingbackend.dao.CategoryDao;
import io.rachidassouani.shoppingbackend.dto.CategoryDto;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = {"/", "home", "index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		
		// adding list of categories
		modelAndView.addObject("categories", categoryDao.listCategories());
		
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("userClicksHome", true);
		return modelAndView;
	}
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "About us");
		modelAndView.addObject("userClicksAbout", true);
		return modelAndView;
	}
	@RequestMapping("listProducts")
	public ModelAndView listProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "List of Products");
		modelAndView.addObject("userClicksHome", true);
		return modelAndView;
	}
	@RequestMapping("contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Contact us");
		modelAndView.addObject("userClicksContact", true);
		return modelAndView;
	}

	/*
	 * Method to load all products
	 */

	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		
		// adding list of categories
		modelAndView.addObject("categories", categoryDao.listCategories());
		
		modelAndView.addObject("title", "list Products");
		modelAndView.addObject("userClicksAllProducts", true);
		return modelAndView;
	}
	
	/*
	 * Method to load all products by category
	 */
	@RequestMapping(value = "show/category/{categoryId}/products")
	public ModelAndView showProductsByCategory(@PathVariable("categoryId")int categoryId) {
		ModelAndView modelAndView = new ModelAndView("page");
		
		CategoryDto category = null;
		category = categoryDao.getCategory(categoryId);
		
		if (category != null) {
			modelAndView.addObject("title", category.getName());
			modelAndView.addObject("category", category);
		}
		// adding list of categories
		modelAndView.addObject("categories", categoryDao.listCategories());
		modelAndView.addObject("userClicksShowProductsByCategory", true);
		return modelAndView;
	}
}
