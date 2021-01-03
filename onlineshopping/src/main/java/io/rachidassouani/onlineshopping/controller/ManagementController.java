package io.rachidassouani.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.rachidassouani.shoppingbackend.dao.CategoryRepository;
import io.rachidassouani.shoppingbackend.dao.ProductRepository;
import io.rachidassouani.shoppingbackend.model.Category;
import io.rachidassouani.shoppingbackend.model.Product;

@Controller
@RequestMapping("manage")
public class ManagementController {

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	@GetMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name="operation", required = false) String operation) {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("userClicksManageProducts", true);
		modelAndView.addObject("title", "Manage Products");
		
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		
		modelAndView.addObject("product", newProduct);
		
		if (operation != null) {
			if (operation.equals("product")) {
				modelAndView.addObject("message", "product added successfully");
			}
		}
		
		
		return modelAndView;
	}
	
	@ModelAttribute("categories")
	public List<Category> categories(){
		return categoryRepository.findAllCategories();
	}
	
	// handler product submission
	@PostMapping("/products")
	public String handlerProductSubmission(@ModelAttribute("product") Product product) throws Exception {
		logger.info(product.toString());
		
		productRepository.addProduct(product);
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	
	
	
}
