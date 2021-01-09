package io.rachidassouani.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.rachidassouani.shoppingbackend.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// 100 % target will have Product type, thanks to supports method!
		Product product = (Product) target;
		
		
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "please select an image to upload!");
			return;
		}
		// if file not in (jpeg, png, gif)
		if (!(product.getFile().getContentType().equals("image/jpeg") ||
			  product.getFile().getContentType().equals("image/png")  ||
			  product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "type of file should be png, jpeg or gif");
			return; 
		}
		
	}

}
