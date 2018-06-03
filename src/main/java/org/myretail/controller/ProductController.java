package org.myretail.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.myretail.model.ProductModel;
import org.myretail.service.ProductService;
import org.myretail.utils.ProductExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myretail")
public class ProductController {
	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductModel> getProductById(@PathVariable int id) throws Exception {
		logger.info("Inside Product Controller : getProductById");
		ResponseEntity<ProductModel> entity = new ResponseEntity<ProductModel>(productService.getProductById(id),
				HttpStatus.OK);
		return entity;
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
	public void updateProductPrice(@RequestBody ProductModel productModel, @PathVariable int id)
			throws SQLException, ProductExceptionHandler {
		logger.info("Inside Product Controller : updateProductPrice");
		productService.updateProductPrice(id, productModel);
	}
}