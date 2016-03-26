package edu.ahu.cst.zsd.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ahu.cst.zsd.domain.Product;
import edu.ahu.cst.zsd.form.ProductForm;

@Controller
public class ProductController {

//	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@RequestMapping(value="/product_input")
	public String inputProduct(){
//		logger.info("调用了inputProduct方法");
		return "ProductForm";
	}
	
	@RequestMapping(value="/product_save")
	public String saveProduct(ProductForm pf,Model model){
//		logger.info("调用了saveProduct方法");
		Product product = new Product();
		product.setId(pf.getId());
		product.setName(pf.getName());
		try {
			product.setPrice(Float.parseFloat(pf.getPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("product", product);
		return "ProductDetails";
	}
}
