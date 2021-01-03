package io.rachidassouani.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.rachidassouani.shoppingbackend.dao.CategoryRepository;
import io.rachidassouani.shoppingbackend.dao.ProductRepository;
import io.rachidassouani.shoppingbackend.model.Category;
import io.rachidassouani.shoppingbackend.model.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		
		logger.info("inside index method that exist in PageController - INFO");
		logger.info("inside index method that exist in PageController - DEBUG");

		// adding list of categories
		modelAndView.addObject("categories", categoryRepository.findAllCategories());

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
		modelAndView.addObject("categories", categoryRepository.findAllCategories());

		modelAndView.addObject("title", "list Products");
		modelAndView.addObject("userClicksAllProducts", true);
		return modelAndView;
	}

	/*
	 * Method to load all products by category
	 */
	@RequestMapping(value = "show/category/{categoryCode}/products")
	public ModelAndView showProductsByCategory(@PathVariable("categoryCode") String categoryCode) {
		ModelAndView modelAndView = new ModelAndView("page");

		Category category = null;
		category = categoryRepository.findCategory(categoryCode);
		
		System.out.println("************** category founded " +category.getName());
		
		if (category != null) {
			modelAndView.addObject("title", category.getName());
			modelAndView.addObject("category", category);
		}
		// adding list of categories
		modelAndView.addObject("categories", categoryRepository.findAllCategories());
		modelAndView.addObject("userClicksShowProductsByCategory", true);
		return modelAndView;
	}
	
	// view single product
	
	@GetMapping("show/{productCode}/product")
	public ModelAndView viewProduct(@PathVariable("productCode") String productCode) throws Exception {
		ModelAndView modelAndView = new ModelAndView("page");
		Product product = productRepository.findProductByCode(productCode);
		
		
		
		if (product != null) {
			// each click on a product , we increment views by 1
			product.setViews(product.getViews() + 1);
			productRepository.updateProduct(product);
			
			modelAndView.addObject("title", product.getName());
			modelAndView.addObject("product", product);
			modelAndView.addObject("userClicksShowProduct", true);
			
			return modelAndView;
		} else {
			throw new Exception();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
