package org.myretail.dao;

import java.sql.SQLException;

import org.myretail.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public interface ProductDao {

	public ProductModel getProductById(int id) throws SQLException;

	public void updateProductPrice(int id, float newPrice) throws SQLException;
}
