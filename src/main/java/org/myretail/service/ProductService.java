package org.myretail.service;

import java.sql.SQLException;

import org.myretail.model.ProductModel;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	public ProductModel getProductById(int id) throws SQLException;

	public void updateProductPrice(int id, ProductModel productModel) throws SQLException;

}
