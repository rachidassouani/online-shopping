package io.rachidassouani.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle", "the page is not constructed");
		modelAndView.addObject("errorDescription", "the page is not available right now!");
		modelAndView.addObject("title", "404 Error page");
		
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException() {
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle", "error");
		modelAndView.addObject("errorDescription", "Oops! product not found");
		modelAndView.addObject("title", "404 Error page");
		
		return modelAndView;
	}
}
