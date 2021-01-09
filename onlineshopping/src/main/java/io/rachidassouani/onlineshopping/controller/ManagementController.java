package io.rachidassouani.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.rachidassouani.onlineshopping.util.FileUploadUtility;
import io.rachidassouani.onlineshopping.validator.ProductValidator;
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
	public String handlerProductSubmission(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		
		new ProductValidator().validate(product, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClicksManageProducts", true);
			return "page";
		}
		
		
		
		productRepository.addProduct(product);
		
		// cheack if theres an image or not
		if (!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(), product.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	
	
	
}
