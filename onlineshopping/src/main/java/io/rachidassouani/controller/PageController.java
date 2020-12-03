package io.rachidassouani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	
	@RequestMapping(value = {"/", "home", "index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
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

}
